package me.kkihwan.web.shared.exception;

import lombok.Getter;
import lombok.ToString;
import me.kkihwan.web.shared.exception.model.Error;

import java.util.List;


@Getter @ToString
public class BusinessException extends RuntimeException {
    private final int code;
    private final String message;
    private final List<Error> errors;

    public BusinessException(int code, String message, List<Error> errors, Throwable cause) {
        super(cause);
        this.code = code;
        this.message = message;
        this.errors = errors;
    }

    // TODO: 성능에 이슈여부 다시 확인 후 재정의 코드 구현하기.
    /*
    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
    */
}
