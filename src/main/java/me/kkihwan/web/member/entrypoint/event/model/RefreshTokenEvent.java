package me.kkihwan.web.member.entrypoint.event.model;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class RefreshTokenEvent {
    private final Long memberId;
    private final String refreshToken;

    public RefreshTokenEvent(Long memberId, String refreshToken) {
        this.memberId = memberId;
        this.refreshToken = refreshToken;
    }

}
