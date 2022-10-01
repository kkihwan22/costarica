package me.kkihwan.web.member.domain;

import lombok.*;
import me.kkihwan.web.member.domain.converter.*;
import me.kkihwan.web.shared.domain.*;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@NoArgsConstructor
@Entity
@Table(name = "member_role")
@DynamicInsert
@DynamicUpdate
@Getter @ToString(exclude = {"member"})
public class MemberRole extends BaseDateTime {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @Setter
    private Member member;

    @Convert(converter = MemberRoleCodeConverter.class)
    @Column(name = "code_name")
    private MemberRoleCode codeName;

    public MemberRole(Long id, MemberRoleCode codeName) {
        this.id = id;
        this.codeName = codeName;
    }
}