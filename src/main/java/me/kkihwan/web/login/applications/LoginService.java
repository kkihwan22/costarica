package me.kkihwan.web.login.applications;

import me.kkihwan.web.login.applications.model.LoginParameter;

public interface LoginService {
    void login(LoginParameter parameter);
    void logout();
}
