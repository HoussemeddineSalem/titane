package dev.titane.users.repositories;

import dev.titane.users.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.inject.Singleton;

@Singleton
public interface MemberRepository extends JpaRepository<Member,Long> {
}
