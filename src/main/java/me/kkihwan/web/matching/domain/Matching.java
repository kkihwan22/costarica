package me.kkihwan.web.matching.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import me.kkihwan.web.matching.domain.converter.MatchingStatusConverter;
import me.kkihwan.web.shared.domain.BaseDateTime;
import me.kkihwan.web.shared.domain.vo.Address;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "matching")
@DynamicInsert
@DynamicUpdate
@Getter @ToString()
public class Matching extends BaseDateTime {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Convert(converter = MatchingStatusConverter.class)
    @Column(name = "status")
    private MatchingStatus status;

    @Column(name = "start_at")
    private LocalDateTime startDateTime;

    @Column(name = "end_at")
    private LocalDateTime endDateTime;

    @Column(name = "min_photographer_cnt")
    private int minPhotographerCnt;

    @Column(name = "max_photographer_cnt")
    private int maxPhotographerCount;

    @Column(name = "min_cosplayer_count")
    private int minCosplayerCount;

    @Column(name = "max_cosplayer_cnt")
    private int maxCosplayerCount;

    @Column(name = "applied_photographer_cnt")
    private int appliedPhotographerCount;

    @Column(name = "applied_cosplayer_count")
    private int appliedCosplayerCount;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "si", column = @Column(name = "si")),
            @AttributeOverride(name = "gun", column = @Column(name = "gun")),
            @AttributeOverride(name = "gu", column = @Column(name = "gu")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "postal_code")),
            @AttributeOverride(name = "detail", column = @Column(name = "detail")),
    })
    private Address address;

    @OneToMany(mappedBy = "matching")
    private List<MatchingAttendee> attendees;

}