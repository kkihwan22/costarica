package me.kkihwan.web.shared.domain.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@NoArgsConstructor
@Getter @ToString
public class Period {
    private LocalDateTime from;
    private LocalDateTime to;
}
