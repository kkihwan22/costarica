package me.kkihwan.web.member.application;

import me.kkihwan.web.member.application.model.RefreshTokenParameter;

public interface AuthenticationService {
    void saveRefreshToken(RefreshTokenParameter parameter);
    String issueAccessTokenByRefreshToken(String refreshToken);
}