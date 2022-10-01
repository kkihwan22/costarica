package me.kkihwan.web.config.security;

import lombok.*;

@NoArgsConstructor
@Getter @ToString
public class LoginRequest {
    private String username;
    private String password;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
