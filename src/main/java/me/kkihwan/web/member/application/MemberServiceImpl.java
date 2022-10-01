package me.kkihwan.web.member.application;

import lombok.*;
import me.kkihwan.web.member.application.model.MemberRegisterParameter;
import me.kkihwan.web.member.domain.*;
import org.slf4j.*;
import org.springframework.stereotype.*;

import javax.transaction.*;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    private final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
    private final MemberJpaRepository memberJpaRepository;
    private final MemberRoleJpaRepository memberRoleJpaRepository;

    @Transactional
    @Override
    public Long registerMember(MemberRegisterParameter parameter) {
        // todo: 인증여부 확인.!
        // todo: phone 번호 등록 수정

        Member registerMember = parameter.toMember();
        memberJpaRepository.save(registerMember);

        MemberRole role = new MemberRole(null, MemberRoleCode.USER);
        registerMember.addRole(role);
        memberRoleJpaRepository.save(role);

        log.debug("register member: {}", registerMember);
        log.debug("roles: {}", registerMember.getRoles());

        return registerMember.getId();
    }
}
