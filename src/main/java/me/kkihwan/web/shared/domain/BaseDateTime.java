package me.kkihwan.web.shared.domain;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @ToString
public abstract class BaseDateTime {
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
