package me.kkihwan.web.share.domain;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public abstract class BaseDomain extends BaseDateTime {
    private Long createdBy;
    private Long updatedBy;
}
