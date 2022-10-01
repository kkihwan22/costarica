package me.kkihwan.web.member.application.model;

import lombok.Getter;
import lombok.ToString;
import me.kkihwan.web.member.domain.Member;
import me.kkihwan.web.member.domain.MemberStatus;

@Getter @ToString
public class MemberRegisterParameter {
    private final String email;
    private final String nickname;
    private final String password;

    public MemberRegisterParameter(
            final String email,
            final String nickname,
            final String password) {

        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }

    public Member toMember() {
        return new Member(null, nickname, password, email, MemberStatus.ACTIVE);
    }
}