package me.kkihwan.web.member.exception;

import me.kkihwan.web.shared.exception.BusinessException;

public class NotMatchedVerifyCodeException extends BusinessException {
    private final static MemberErrorCode errorCode = MemberErrorCode.NOT_MATCHED_TOKEN;

    public NotMatchedVerifyCodeException() {
        super(errorCode.getCode(), errorCode.getMessage());
    }
}
