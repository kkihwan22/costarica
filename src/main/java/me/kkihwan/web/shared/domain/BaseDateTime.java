package me.kkihwan.web.shared.domain;

import lombok.*;

import javax.persistence.*;
import java.time.*;

@MappedSuperclass
@ToString
public abstract class BaseDateTime extends BaseCreatedDateTime {

    @Column(name = "updated_dt")
    @Getter
    private LocalDateTime updatedDateTime;
}
