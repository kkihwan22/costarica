package me.kkihwan.web.share.domain.vo;

import lombok.Getter;
import lombok.ToString;
import me.kkihwan.web.member.domain.vo.TelecomCompany;

@Getter @ToString
public class Contact {
    private TelecomCompany telecomCompany;
    private String mobileNumber;
    private String phoneNumber;
}