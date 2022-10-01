package me.kkihwan.web.member.entrypoint.rest.model;

import lombok.Getter;
import lombok.ToString;
import me.kkihwan.web.member.application.model.MemberRegisterParameter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter @ToString
public class MemberRegisterRequest {

    @NotBlank(message = "닉네임을 입력해주세요.")
    private String nickname;

    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "이메일 형식에 맞지 않습니다.")
    private String email;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;

    public MemberRegisterParameter to() {
        return new MemberRegisterParameter(email, nickname, password);
    }
}