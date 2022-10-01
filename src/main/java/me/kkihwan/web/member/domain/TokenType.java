package me.kkihwan.web.member.domain;

import lombok.*;

public enum TokenType {

    ACCESS_TOKEN(1200L),
    REFRESH_TOKEN((60 * 60 * 24 * 7L))
    ;

    @Getter
    private final long expireTime;

    TokenType(long expireTime) {
        this.expireTime = expireTime;
    }
}
