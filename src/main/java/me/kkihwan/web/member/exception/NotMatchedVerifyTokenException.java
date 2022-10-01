package me.kkihwan.web.member.exception;

import me.kkihwan.web.shared.exception.BusinessException;

public class NotMatchedVerifyTokenException extends BusinessException {
    private final static MemberErrorCode errorCode = MemberErrorCode.NOT_MATCHED_TOKEN;

    public NotMatchedVerifyTokenException() {
        super(errorCode.getCode(), errorCode.getMessage());
    }
}
