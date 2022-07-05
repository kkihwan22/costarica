package me.kkihwan.web.share.exceptions.model;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class Error {

    private String context;
    private String reason;

    /**
     * @param context 는 에러가 발생한 위치에 대한 정보를 담는다.
     * @param reason 는 에러가 발생한 원인에 대한 정보를 담는다.
     */
    public Error(String context, String reason) {
        this.context = context;
        this.reason = reason;
    }
}