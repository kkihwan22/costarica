package me.kkihwan.web.login.application;

import me.kkihwan.web.login.application.model.LoginParameter;

public interface LoginService {
    void login(LoginParameter parameter);
    void logout();
}
