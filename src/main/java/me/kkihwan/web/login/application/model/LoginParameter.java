package me.kkihwan.web.login.application.model;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class LoginParameter {
    private String loginId;
    private String password;

    public LoginParameter(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }
}
