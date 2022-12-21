package dev.titane.users.services;

import dev.titane.users.entities.Member;
import dev.titane.users.models.MemberDTO;
import dev.titane.users.repositories.MemberRepository;
import dev.titane.users.utils.MemberMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class MemberServiceImp implements MemberService {

    MemberRepository memberRepository;
    MemberMapper memberMapper;

    @Override
    public Long createMember(MemberDTO memberDTO) {
        Member memberDAO = memberMapper.toDAO(memberDTO);
        Member member = memberRepository.save(memberDAO);
        return member.getId();
    }

    @Override
    public List<MemberDTO> getMembers(String firstName, String lastName, String email) {

        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();

        Example<Member> exampleQuery = Example.of(new Member(null, firstName, lastName, email), matcher);
        List<Member> memberList = memberRepository.findAll(exampleQuery);

        return memberList.stream().map(member -> memberMapper.toDTO(member)).collect(Collectors.toList());

    }

    @Override
    public MemberDTO updateMember(MemberDTO memberDTO) {

        Member memberDAO = memberMapper.toDAO(memberDTO);
        Member member = memberRepository.save(memberDAO);

        return memberMapper.toDTO(member);
    }

    @Override
    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }
}
