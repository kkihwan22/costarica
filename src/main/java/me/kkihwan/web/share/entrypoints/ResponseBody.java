package me.kkihwan.web.share.entrypoints;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseBody<?> that = (ResponseBody<?>) o;
        return code == that.code && Objects.equals(message, that.message) && Objects.equals(traceId, that.traceId) && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message, traceId, data);
    }
}
