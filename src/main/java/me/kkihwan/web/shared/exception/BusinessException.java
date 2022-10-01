package me.kkihwan.web.shared.exception;

import lombok.*;
import me.kkihwan.web.shared.exception.model.ErrorBodyData;

import java.util.*;


@Getter @ToString
public class BusinessException extends RuntimeException {
    private final int code;
    private final String message;
    private final List<ErrorBodyData> errorBodyData;

    public BusinessException(int code, String message, List<ErrorBodyData> errorBodyData) {
        this.code = code;
        this.message = message;
        this.errorBodyData = errorBodyData;
    }

    public BusinessException(int code, String message) {
        this.code = code;
        this.message = message;
        this.errorBodyData = Collections.emptyList();
    }

    // TODO: 성능에 이슈여부 다시 확인 후 재정의 코드 구현하기.
    /*
    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
    */
}
