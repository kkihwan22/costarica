package me.kkihwan.web.studio.domain;

import lombok.Getter;
import lombok.ToString;
import me.kkihwan.web.share.domain.BaseWriteDateTime;
import me.kkihwan.web.share.domain.vo.Contact;

import java.util.List;

@Getter @ToString
public class Studio extends BaseWriteDateTime {
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