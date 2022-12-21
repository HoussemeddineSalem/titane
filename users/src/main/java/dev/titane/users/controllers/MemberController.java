package dev.titane.users.controllers;

import dev.titane.users.models.MemberDTO;
import dev.titane.users.services.MemberService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/member")
@AllArgsConstructor
public class MemberController {

    MemberService memberService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long createMember(@RequestBody MemberDTO memberDTO){
        return memberService.createMember(memberDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MemberDTO> getMember(){
        return memberService.getMembers(null,null,null);
    }

}
