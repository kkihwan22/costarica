package me.kkihwan.web.config.security.exception;

import lombok.Getter;

import static me.kkihwan.web.config.security.exception.SecurityErrorCode.NOT_EXIST_TOKEN;


public class TokenNotExistException extends RuntimeException {
    @Getter
    private final static SecurityErrorCode errorCode = NOT_EXIST_TOKEN;
}
