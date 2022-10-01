package me.kkihwan.web.member.exception;

import me.kkihwan.web.shared.exception.BusinessException;

public class ExpiredVerifyTokenException extends BusinessException {
    private final static MemberErrorCode errorCode = MemberErrorCode.EXPIRED_TOKEN;

    public ExpiredVerifyTokenException() {
        super(errorCode.getCode(), errorCode.getMessage());
    }
}
