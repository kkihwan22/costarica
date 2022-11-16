package me.kkihwan.web.matching.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import me.kkihwan.web.matching.domain.converter.MatchingStatusConverter;
import me.kkihwan.web.shared.domain.BaseDateTime;
import me.kkihwan.web.shared.domain.vo.Address;
import me.kkihwan.web.shared.domain.vo.Capacity;
import me.kkihwan.web.shared.domain.vo.Period;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
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

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "from", column = @Column(name = "start_at")),
            @AttributeOverride(name = "to", column = @Column(name = "end_at")),
    })
    private Period period;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "min", column = @Column(name = "min_photographer_cnt")),
            @AttributeOverride(name = "max", column = @Column(name = "max_photographer_cnt")),
    })
    private Capacity photographerCapacity;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "min", column = @Column(name = "min_cosplayer_cnt")),
            @AttributeOverride(name = "max", column = @Column(name = "max_cosplayer_cnt")),
    })
    private Capacity cosplayerCapacity;

    @Column(name = "applied_photographer_cnt")
    private int appliedPhotographerCount;

    @Column(name = "applied_cosplayer_cnt")
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