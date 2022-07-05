package me.kkihwan.web.share.exceptions;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class UnknownException extends RuntimeException {
    private final int code = -1;
    private final String message = "error.unknown";

    public UnknownException(Throwable cause) {
        super(cause);
    }
}