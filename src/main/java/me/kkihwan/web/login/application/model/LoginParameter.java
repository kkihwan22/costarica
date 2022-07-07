package me.kkihwan.web.login.application.model;

import lombok.Getter;
import lombok.ToString;
import me.kkihwan.web.shared.application.ParameterValidator;

import javax.validation.constraints.NotBlank;

@Getter @ToString
public class LoginParameter extends ParameterValidator<LoginParameter> {
    @NotBlank
    private final String loginId;

    @NotBlank
    private final String password;

    public LoginParameter(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
        this.validate();
    }
}
