package me.kkihwan.web.member.exception;


import me.kkihwan.web.shared.exception.BusinessException;

public class NotFoundMemberException extends BusinessException {

    private final static MemberErrorCode errorCode = MemberErrorCode.NOT_FOUND_MEMBER;

    public NotFoundMemberException() {
        super(errorCode.getCode(), errorCode.getMessage());
    }
}
