package me.kkihwan.web.studio.domain;

import lombok.Getter;
import lombok.ToString;
import me.kkihwan.web.shared.domain.BaseWriteDateTime;

import java.util.List;

@Getter @ToString
public class StudioReview extends BaseWriteDateTime {
    private Long id;
    private Studio studio;
    private String title;
    private String content;
    private List<Long> reviewImages;
    private float rating;
}