package me.kkihwan.web.shared.domain.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@Getter @ToString
public class Address {
    //TODO : 시/군/구 코드 도입도 고려해보자
    private String si;
    private String gun;
    private String gu;
    private String postalCode;
    private String detail;
}
