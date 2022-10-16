package me.kkihwan.web.member.domain;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.Getter;
import lombok.ToString;
import me.kkihwan.web.config.security.CustomUserDetails;
import me.kkihwan.web.config.security.exception.AccessTokenExpiredException;
import me.kkihwan.web.member.exception.ExpiredVerifyTokenException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.*;
import java.util.stream.*;

@Getter @ToString
public class Token {
    private static final Logger log = LoggerFactory.getLogger(Token.class);
    private static final String ISS = "COSQUARE";
    private static final String SECRET = "SeCrEtKeY4HaShInG";
    private static final Algorithm ALGORITHM = Algorithm.HMAC256(SECRET);

    private final String value;
    private final TokenType type;

    public Token(String value, TokenType type) {
        this.value = value;
        this.type = type;
    }


    public static Token build(TokenType type, UserDetails userDetails) {
        CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
        log.debug(" [JWT] customUserDetails : {} ", customUserDetails);

        return new Token(JWT.create()
                .withIssuer(ISS)
                .withClaim("exp", Instant.now().getEpochSecond() + type.getExpireTime())
                .withClaim("username", customUserDetails.getUsername())
                .withClaim("nickname", customUserDetails.getNickname())
                .withClaim("id", customUserDetails.getId())
                .withClaim("authorities", Token.convertToString(customUserDetails.getAuthorities()))
                .sign(ALGORITHM), type);

    }

    public TokenVerified verify() {
        try {
            DecodedJWT decoded = JWT.require(ALGORITHM)
                    .build()
                    .verify(this.value);

            Long exp = decoded.getClaim("exp").asLong();
            long now = Instant.now().getEpochSecond();
            if (exp < now) {
                log.info("token expired. now : {}, exp : {}", now, exp);
                throw new ExpiredVerifyTokenException();
            }

            return TokenVerified.success(extraPayload(decoded));
        } catch (TokenExpiredException e) {
            log.info("[ Token ] 만료되었습니다. {}", e);
            throw new AccessTokenExpiredException();
        } catch (Exception e) {
            DecodedJWT decoded = JWT.decode(value);
            log.info("[ error ] verifying token. e : ", e);
            return TokenVerified.failure(extraPayload(decoded));
        }
    }

    private UserDetails extraPayload(DecodedJWT decoded) {
        Long id = decoded.getClaim("id").asLong();
        String username = decoded.getClaim("username").asString();
        String nickname = decoded.getClaim("nickname").asString();
        String authorities = decoded.getClaim("authorities").asString();

        log.debug(" Extra ID : {}", id);

        Set<SimpleGrantedAuthority> roles = Arrays.stream(authorities.split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());

        return new CustomUserDetails(id, nickname, username, "", roles);
    }

    private static String convertToString(Set<SimpleGrantedAuthority> authorities) {
        return authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
    }
}