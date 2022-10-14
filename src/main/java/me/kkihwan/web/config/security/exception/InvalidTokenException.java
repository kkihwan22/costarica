package me.kkihwan.web.config.security.exception;

import lombok.Getter;

import static me.kkihwan.web.config.security.exception.SecurityErrorCode.INVALID_TOKEN;

public class InvalidTokenException extends RuntimeException {
    @Getter
    private final static SecurityErrorCode errorCode = INVALID_TOKEN;
}
