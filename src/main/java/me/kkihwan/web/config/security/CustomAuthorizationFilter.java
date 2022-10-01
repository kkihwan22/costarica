package me.kkihwan.web.config.security;

import lombok.RequiredArgsConstructor;
import me.kkihwan.web.config.security.exception.InvalidTokenException;
import me.kkihwan.web.config.security.exception.NotExistTokenException;
import me.kkihwan.web.member.domain.Token;
import me.kkihwan.web.member.domain.TokenType;
import me.kkihwan.web.member.domain.TokenVerified;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RequiredArgsConstructor
@Component
public class CustomAuthorizationFilter extends OncePerRequestFilter {
    private final Logger log = LoggerFactory.getLogger(CustomAuthorizationFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        log.debug("[ filter ] execute authorization filter.");

        if (request.getServletPath().startsWith("/public")) {
            filterChain.doFilter(request, response);
            return;
        }

        String authorizationHeader = Optional
                .ofNullable(request.getHeader(AUTHORIZATION))
                .orElseThrow(NotExistTokenException::new);

        if (!authorizationHeader.startsWith("Bearer ")) {
            throw new InvalidTokenException();
        }

        String key = authorizationHeader.substring("Bearer ".length());
        Token requestToken = new Token(key, TokenType.ACCESS_TOKEN);

        TokenVerified verify = requestToken.verify();

        if (!verify.isVerified()) {
            log.info("token invalid. value:{}", key);
            throw new InvalidTokenException();
        }

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(verify.getUsername(), null, verify.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        filterChain.doFilter(request, response);
    }
}