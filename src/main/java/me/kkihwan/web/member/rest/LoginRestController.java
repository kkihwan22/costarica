package me.kkihwan.web.member.rest;

import lombok.RequiredArgsConstructor;
import me.kkihwan.web.member.application.LoginService;
import me.kkihwan.web.member.application.model.LoginParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LoginRestController {
    private final Logger LOG = LoggerFactory.getLogger(LoginRestController.class);
    private final LoginService loginService;

    @PostMapping("/login")
    public void login(LoginParameter parameter) {
        loginService.login(parameter);
        // Member 정보를 조회한다. (QueryService 분리)
    }
}
