package me.kkihwan.web.login.application;

import lombok.RequiredArgsConstructor;
import me.kkihwan.web.login.application.model.LoginParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {
    private final Logger LOG = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Override
    public void login(LoginParameter parameter) {
        LOG.debug("[ parameter ] {}", parameter);
    }

    @Override
    public void logout() {
    }
}