package me.kkihwan.web.matching.domain;

import lombok.*;
import me.kkihwan.web.matching.domain.converter.MatchingStatusConverter;
import me.kkihwan.web.shared.domain.BaseDateTime;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "matching")
@DynamicInsert
@DynamicUpdate
@Builder
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

    @Column(name = "start_date_time")
    private LocalDateTime startDatetime;

    @Column(name = "end_date_time")
    private LocalDateTime endDatetime;

    @Builder.Default
    @Column(name = "min_photographer_cnt")
    private Integer minPhotographerCnt = 0;

    @Column(name = "max_photographer_cnt")
    @Builder.Default
    private Integer maxPhotographerCount = 0;

    @Builder.Default
    @Column(name = "min_cosplayer_count")
    private Integer minCosplayerCount = 0;

    @Builder.Default
    @Column(name = "max_cosplayer_cnt")
    private Integer maxCosplayerCount = 0;

    @Builder.Default
    @Column(name = "applied_photographer_cnt")
    private Integer appliedPhotographerCount = 0;

    @Builder.Default
    @Column(name = "applied_cosplayer_count")
    private Integer appliedCosplayerCount = 0;

    //TODO : 시/군/구 주소 추가예정

    @Builder.Default
    @OneToMany(mappedBy = "matching")
    private List<MatchingAttendee> attendees = new ArrayList<>();

}