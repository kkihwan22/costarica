package me.kkihwan.web.shared.domain;

import lombok.*;

import javax.persistence.*;
import java.time.*;

@MappedSuperclass
@ToString
public abstract class BaseCreatedDateTime {

    @Column(name = "created_dt")
    @Getter
    private LocalDateTime createdDateTime;
}
