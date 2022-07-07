package me.kkihwan.web.member.domain;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @ToString
public class Account {
    private Long id;
    private String loginId;
    private String password;
    private AccountType type;
    private AccountStatus status;
    private Integer loginFailedCount;
    private Boolean verified;
    private Long memberId;
    private LocalDateTime lastLoginDateTime;
    private LocalDateTime changedPasswordDateTime;
}