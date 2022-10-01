package me.kkihwan.web.member.domain;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface MemberRoleJpaRepository extends JpaRepository<MemberRole, Long> {

}
