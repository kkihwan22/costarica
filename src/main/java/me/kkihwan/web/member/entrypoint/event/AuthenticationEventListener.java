package me.kkihwan.web.member.entrypoint.event;

import lombok.RequiredArgsConstructor;
import me.kkihwan.web.member.application.AuthenticationService;
import me.kkihwan.web.member.application.model.RefreshTokenParameter;
import me.kkihwan.web.member.entrypoint.event.model.RefreshTokenEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthenticationEventListener {
    private final Logger log = LoggerFactory.getLogger(AuthenticationEventListener.class);
    private final AuthenticationService authenticationService;

    @EventListener
    public void listen(RefreshTokenEvent event) {
        log.debug("event: {}", event);
        authenticationService.saveRefreshToken(new RefreshTokenParameter(event.getMemberId(), event.getRefreshToken()));
    }
}
