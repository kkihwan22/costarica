package me.kkihwan.web.member.entrypoint.rest;

import lombok.RequiredArgsConstructor;
import me.kkihwan.web.member.application.AuthenticationService;
import me.kkihwan.web.shared.entrypoint.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class AuthenticationRestController {
    private final Logger log = LoggerFactory.getLogger(AuthenticationRestController.class);
    private final AuthenticationService authenticationService;

    @PostMapping("/public/v1/login")
    public void login() {
        log.debug("Do nothing.");
    }

    @GetMapping("/public/v1/token/refresh")
    public ResponseEntity<Body<SimpleBodyData<String>>> refreshToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        log.debug("[ Authorization Header ] token : {} ", token);
        String newAccessToken = authenticationService.issueAccessTokenByRefreshToken(token);
        return ResponseEntity.ok(BodyFactory.success(new SimpleBodyData(newAccessToken)));
    }
}
