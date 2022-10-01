package me.kkihwan.web.member.domain;

import lombok.*;
import me.kkihwan.web.shared.domain.BaseDateTime;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "member_token")
@DynamicInsert
@DynamicUpdate
@Getter @ToString
public class MemberToken extends BaseDateTime {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "refresh_token")
    private String refreshToken;
}
