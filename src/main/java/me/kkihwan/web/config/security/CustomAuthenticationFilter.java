package me.kkihwan.web.config.security;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.kkihwan.web.member.domain.Token;
import me.kkihwan.web.member.domain.TokenType;
import me.kkihwan.web.member.entrypoint.event.model.RefreshTokenEvent;
import me.kkihwan.web.shared.entrypoint.BodyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.*;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final static Logger log = LoggerFactory.getLogger(CustomAuthenticationFilter.class);
    private final AuthenticationManager authenticationManager;
    private final ObjectMapper mapper = new ObjectMapper();

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
        this.authenticationManager = authenticationManager;
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        log.debug("[ filter ] execute authentication filter.");

        LoginRequest loginRequest;
        try {
            loginRequest = mapper.readValue(request.getReader().lines().collect(Collectors.joining()), new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new AuthenticationServiceException(" request parsing error. ");
        }

        log.debug(" [ LoginRequest ] {}", loginRequest);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        return authenticationManager.authenticate(token);
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication)
            throws IOException {
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();

        Token refresh = TokenType.REFRESH_TOKEN.factory(user);
        log.info("[ refresh token ] {}", refresh);

        Token access = TokenType.ACCESS_TOKEN.factory(user);
        log.info("[ access token ] {}", access);


        Map<String, String> data = new HashMap<>();
        data.put("refresh_token", refresh.getValue());
        data.put("access_token", access.getValue());

        eventPublisher.publishEvent(new RefreshTokenEvent(user.getId(), refresh.getValue()));

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        mapper.writeValue(response.getOutputStream(), ResponseEntity.ok(BodyFactory.success(data)));

    }
}
