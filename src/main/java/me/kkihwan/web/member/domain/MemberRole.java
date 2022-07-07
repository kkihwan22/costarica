package me.kkihwan.web.member.domain;

import lombok.Getter;
import lombok.ToString;
import me.kkihwan.web.member.domain.vo.RoleCode;

import java.time.LocalDateTime;

@Getter @ToString
public class MemberRole {
    private Long id;
    private Member member;
    private RoleCode roleCode;
    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;
}
