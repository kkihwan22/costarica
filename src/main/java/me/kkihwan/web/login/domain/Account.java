package me.kkihwan.web.login.domain;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @ToString
public class Account {
    private Long id;
    private Long memberId;
    private String loginId;
    private String password;
    private AccountStatus status;
    private int failedLoginCount;
    private LocalDateTime lastLoginDateTime;
    private LocalDateTime changedPasswordDateTime;
}