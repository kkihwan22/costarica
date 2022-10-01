package me.kkihwan.web.member.domain;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface MemberTokenJpaRepository extends JpaRepository<MemberToken, Long> {

    List<MemberToken> findMemberTokenByRefreshToken(String refreshToken);
}
