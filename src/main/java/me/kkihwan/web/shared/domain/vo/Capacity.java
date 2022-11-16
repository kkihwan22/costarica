package me.kkihwan.web.shared.domain.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@Getter @ToString
public class Capacity {
    private int min;
    private int max;
}
