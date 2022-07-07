package me.kkihwan.web.share.domain.vo;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class Address {
    private String postCode;
    private String city;
    private String detail;
    // TODO: 네이버 or 구글 지도 연동 어떻게 하는지 확인
}
