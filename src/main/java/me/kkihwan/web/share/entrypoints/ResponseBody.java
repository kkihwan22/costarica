package me.kkihwan.web.share.entrypoints;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class ResponseBody<T> {
    private int code;
    private String message;
    private String traceId;
    private T data;

    public ResponseBody(int code, String message, String traceId, T data) {
        this.code = code;
        this.message = message;
        this.traceId = traceId;
        this.data = data;
    }
}
