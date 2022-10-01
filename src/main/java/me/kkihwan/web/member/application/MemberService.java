package me.kkihwan.web.member.application;

import me.kkihwan.web.member.application.model.MemberRegisterParameter;

public interface MemberService {

    Long registerMember(MemberRegisterParameter parameter);
}

