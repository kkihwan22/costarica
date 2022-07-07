package me.kkihwan.web.studio.domain;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter @ToString
public class StudioReview {
    private Long id;
    private Studio studio;
    private String title;
    private String content;
    private List<Long> reviewImages;
    private float rating;
}