package me.kkihwan.web.member.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface MemberTokenJpaRepository extends JpaRepository<MemberToken, Long> {

    Optional<MemberToken> findMemberTokenByRefreshToken(String refreshToken);
}
