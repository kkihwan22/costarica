package me.kkihwan.web.member.domain;

import lombok.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public enum TokenType {

    ACCESS_TOKEN(1200L),
    REFRESH_TOKEN((60 * 60 * 24 * 7L))
    ;

    @Getter
    private final long expireTime;

    TokenType(long expireTime) {
        this.expireTime = expireTime;
    }

    public Token factory(UserDetails userDetails) {
        return Token.build(this, userDetails);
    }
}
