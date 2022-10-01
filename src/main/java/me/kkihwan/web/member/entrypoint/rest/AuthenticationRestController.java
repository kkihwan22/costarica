package me.kkihwan.web.member.entrypoint.rest;

import lombok.*;
import org.slf4j.*;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class AuthenticationRestController {
    private final Logger log = LoggerFactory.getLogger(AuthenticationRestController.class);

    @PostMapping("/public/v1/login")
    public void login() {
        log.debug("Do nothing.");
    }

    @GetMapping("/public/v1/token/refresh")
    public void refreshToken() {

    }
}
