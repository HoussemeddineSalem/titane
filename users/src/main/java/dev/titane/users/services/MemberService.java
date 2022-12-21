package dev.titane.users.services;

import dev.titane.users.entities.Member;
import dev.titane.users.models.MemberDTO;

import java.util.List;

public interface MemberService {

    Long createMember(MemberDTO memberDTO);

    List<MemberDTO> getMembers(String firstName, String lastName, String email);

    MemberDTO updateMember(MemberDTO memberDTO);

    void deleteMember(Long memberId);
}
