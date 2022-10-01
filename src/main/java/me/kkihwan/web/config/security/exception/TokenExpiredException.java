package me.kkihwan.web.config.security.exception;

import lombok.*;

public class TokenExpiredException extends RuntimeException {
    @Getter
    private final static SecurityErrorCode errorCode = SecurityErrorCode.EXPIRED_TOKEN;
}
