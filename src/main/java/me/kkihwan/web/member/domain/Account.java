package me.kkihwan.web.member.domain;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@EqualsAndHashCode
@DynamicInsert
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Table(name = "account")
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login_id")
    private String loginId;

    @Column(name = "password")
    private String password;

    @Column(name = "type")
    @Convert(converter = AccountTypeConverter.class)
    private AccountType type;

    @Column(name = "status")
    @Convert(converter = AccountStatusConverter.class)
    private AccountStatus status;

    @Column(name = "login_failed_count")
    private Integer loginFailedCount;

    @Column(name = "verified")
    private Boolean verified;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "last_login_date_time")
    private LocalDateTime lastLoginDateTime;

    @Column(name = "changed_password_date_time")
    private LocalDateTime changedPasswordDateTime;

}