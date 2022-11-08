package me.kkihwan.web.matching.domain;

import lombok.*;
import me.kkihwan.web.member.domain.Member;
import me.kkihwan.web.shared.domain.BaseDateTime;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "matching_attendee")
@DynamicInsert
@DynamicUpdate
@Builder
@Getter @ToString()
public class MatchingAttendee extends BaseDateTime {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "matching_id")
    private Matching matching;

}