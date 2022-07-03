package me.kkihwan.web.share.entrypoints;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class ResponseBodyFactory {
    private final static int SUCCESS_CODE = 0;
    private final static String SUCCESS_MESSAGE = "OK";

    public static <T> ResponseBody<T> success(T data) {
        // TODO: TraceId 가져오는 방법 구현
        return new ResponseBody<>(SUCCESS_CODE, SUCCESS_MESSAGE, "", data);
    }

    // TODO: error() 메소드 구현
}
