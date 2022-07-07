package me.kkihwan.web.member.application;

import me.kkihwan.web.member.application.model.LoginParameter;

public interface LoginService {
    void login(LoginParameter parameter);
    void logout();
}
