package me.kkihwan.web.shared.entrypoint;

import lombok.*;

@Getter @ToString
public class BodyFactory {
    private final static int SUCCESS_CODE = 0;
    private final static String SUCCESS_MESSAGE = "OK";

    public static <T> Body<T> success(T data) {
        // TODO: TraceId 가져오는 방법 구현
        return new Body<>(SUCCESS_CODE, SUCCESS_MESSAGE, "", data);
    }

    // TODO: error() 메소드 구현

    public static <T> Body<T> failure(int code, String message, String traceId, T data) {
        return new Body<>(code, message, traceId, data);
    }
}
