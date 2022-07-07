package me.kkihwan.web.studio.domain;

import lombok.Getter;
import lombok.ToString;
import me.kkihwan.web.shared.domain.vo.Contact;

import java.util.List;

@Getter @ToString
public class Studio {
    private Long id;
    private Long memberId;
    private String studioName;
    private Contact contact;
    private String intro;
    private Long mainStudioImage;
    private List<Long> studioImages;
    private float rating;
    private int wishCount;
    private List<StudioReview> reviews;
}