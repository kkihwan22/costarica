package me.kkihwan.web.config.security.exception;

import lombok.Getter;

public enum SecurityErrorCode {

    UNKNOWN_AUTH(100, "인증 중 알 수 없는 에러가 발생하였습니다."),
    EXPIRED_ACCESS_TOKEN(101, "만료 된 (액세스) 토큰입니다."),
    EXPIRED_REFRESH_TOKEN(102, "만료 된 (리프레쉬) 토큰입니다."),
    INVALID_TOKEN(103, "토큰 정보가 유효하지 않습니다."),
    NOT_EXIST_TOKEN(104, "존재하지 않는 토큰입니다."),

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
