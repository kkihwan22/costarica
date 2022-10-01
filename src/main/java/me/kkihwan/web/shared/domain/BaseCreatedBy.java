package me.kkihwan.web.shared.domain;

import lombok.*;

import javax.persistence.*;

@MappedSuperclass
@ToString
public abstract class BaseCreatedBy extends BaseDateTime {

    @Column(name = "created_by")
    @Getter
    private Long createdBy;

    @Column(name = "updated_by")
    @Getter
    private Long updatedBy;
}
