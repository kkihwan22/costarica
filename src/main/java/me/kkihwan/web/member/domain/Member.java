package me.kkihwan.web.member.domain;

import lombok.Getter;
import lombok.ToString;
import me.kkihwan.web.share.domain.vo.Address;
import me.kkihwan.web.share.domain.vo.Contact;

import java.time.LocalDateTime;
import java.util.List;

@Getter @ToString
public class Member {
    private Long id;
    private List<MemberRole> roles;
    private String name;
    private String nickname;
    private String email;
    private Contact contact;
    private Address address;
    private String profileImageUrl;
    private String snsLinks;
    private Long updatedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
