package dev.titane.users.utils;

import dev.titane.users.entities.Member;
import dev.titane.users.models.MemberDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "jsr330")
public interface MemberMapper {

    Member toDAO(MemberDTO memberDTO);

    MemberDTO toDTO(Member member);
}
