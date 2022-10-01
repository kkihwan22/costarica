package me.kkihwan.web.member.domain;

import lombok.*;
import me.kkihwan.web.member.domain.converter.*;
import me.kkihwan.web.shared.domain.*;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.*;

import static javax.persistence.GenerationType.*;

@NoArgsConstructor
@Entity
@Table(name = "member")
@DynamicInsert
@DynamicUpdate
@Getter @ToString(exclude = "roles")
public class Member extends BaseDateTime {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Convert(converter = MemberStatusConverter.class)
    @Column(name = "status")
    private MemberStatus status;

    @OneToMany(mappedBy = "member")
    private List<MemberRole> roles;

    public Member(Long id, String email, String password, String nickname, MemberStatus status) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.status = status;
    }

    public void addRole(MemberRole role) {
        if (roles == null) {
            roles = new ArrayList<>();
        }
        roles.add(role);
        role.setMember(this);
    }

    public void removeRole(MemberRole role) {
        roles.remove(role);
        role.setMember(null);
    }
}