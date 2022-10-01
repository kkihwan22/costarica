package me.kkihwan.web.member.domain;

import com.auth0.jwt.*;
import com.auth0.jwt.algorithms.*;
import com.auth0.jwt.interfaces.*;
import lombok.*;
import me.kkihwan.web.member.exception.ExpiredVerifyTokenException;
import org.slf4j.*;
import org.springframework.security.core.*;

import java.time.*;
import java.util.*;
import java.util.stream.*;

@Getter @ToString
public class Token {
    private static final Logger log = LoggerFactory.getLogger(Token.class);
    private static final String ISS = "CREAME";
    private static final String SECRET = "SeCrEtKeY4HaShInG";
    private static final Algorithm ALGORITHM = Algorithm.HMAC256(SECRET);

    private final String value;
    private final TokenType type;

    public Token(String value, TokenType type) {
        this.value = value;
        this.type = type;
    }

    public static Token accessToken(String username, Collection<GrantedAuthority> authorities) {
        return new Token(JWT.create()
                .withIssuer(ISS)
                .withClaim("exp", Instant.now().getEpochSecond() + TokenType.ACCESS_TOKEN.getExpireTime())
                .withClaim("username", username)
                .withClaim("authorities", Token.convertToString(authorities))
                .sign(ALGORITHM), TokenType.ACCESS_TOKEN);
    }

    public static Token refreshToken(String username, Collection<GrantedAuthority> authorities) {
        return new Token(JWT.create()
                .withIssuer(ISS)
                .withClaim("exp", Instant.now().getEpochSecond() + TokenType.REFRESH_TOKEN.getExpireTime())
                .withClaim("username", username)
                .withClaim("authorities", Token.convertToString(authorities))
                .sign(Algorithm.HMAC256(SECRET)), TokenType.REFRESH_TOKEN);
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

            String username = decoded.getClaim("username").asString();
            String authorities = decoded.getClaim("authorities").asString();
            return TokenVerified.success(username, authorities);

        } catch (Exception e) {
            DecodedJWT decoded = JWT.decode(value);
            log.info("[ error ] verifying token. e : ", e);
            String username = decoded.getClaim("username").asString();
            String authorities = decoded.getClaim("authorities").asString();
            return TokenVerified.failure(username, authorities);
        }
    }

    private static String convertToString(Collection<GrantedAuthority> authorities) {
        return authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
    }
}