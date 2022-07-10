package me.kkihwan.web.member.application.model;

import lombok.Getter;
import lombok.ToString;
import me.kkihwan.web.member.domain.Account;
import me.kkihwan.web.shared.application.ParameterValidator;

import javax.validation.constraints.NotBlank;

@Getter @ToString
public class AccountParameter extends ParameterValidator<AccountParameter> {
    @NotBlank
    private final String loginId;

    @NotBlank
    private final String password;

    public AccountParameter(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
        this.validate();
    }

    public Account toEntity() {
        return Account.builder()
                .loginId(this.loginId)
                .password(this.password)
                .build();
    }
}
