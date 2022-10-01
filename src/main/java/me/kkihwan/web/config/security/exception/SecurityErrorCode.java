package me.kkihwan.web.config.security.exception;

import lombok.*;

public enum SecurityErrorCode {

    EXPIRED_TOKEN(100, "토큰이 만료되었습니다."),
    INVALID_TOKEN(101, "토큰 정보가 유효하지 않습니다."),
    UNKNOWN_AUTH(102, "인증 중 알 수 없는 에러가 발생하였습니다.")
    ;

    @Getter
    private final int code;
    @Getter
    private final String message;

    SecurityErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
