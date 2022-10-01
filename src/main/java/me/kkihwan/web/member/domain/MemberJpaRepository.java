package me.kkihwan.web.member.domain;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface MemberJpaRepository extends JpaRepository<Member, Long> {

    Optional<Member> findFirstByOrderById();

    Optional<Member> findByEmail(String email);

    @Query("select m from Member m join fetch m.roles where m.email = :email")
    Optional<Member> findByUserDetails(String email);
}
