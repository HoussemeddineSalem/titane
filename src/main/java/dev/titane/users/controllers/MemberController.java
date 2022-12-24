package dev.titane.users.controllers;

import dev.titane.users.models.MemberDTO;
import dev.titane.users.services.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/member")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class MemberController {

    MemberService memberService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long createMember(@RequestBody MemberDTO memberDTO) {
        return memberService.createMember(memberDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MemberDTO> getMember(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email) {
        return memberService.getMembers(firstName, lastName, email);
    }

    @PutMapping("/{memberId}")
    @ResponseStatus(HttpStatus.OK)
    public MemberDTO updateMember(
            @PathVariable("memberId") Long memberId,
            @RequestBody MemberDTO memberDTO) {
        return memberService.updateMember(memberId, memberDTO);
    }

    @DeleteMapping("/{memberId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMember(@PathVariable("memberId") Long memberId) {
        memberService.deleteMember(memberId);
    }

}
