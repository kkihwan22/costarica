package me.kkihwan.web.member.domain.converter;

import me.kkihwan.web.member.domain.MemberRoleCode;

import javax.persistence.*;

@Converter
public class MemberRoleCodeConverter implements AttributeConverter<MemberRoleCode, String> {

    @Override
    public String convertToDatabaseColumn(MemberRoleCode attribute) {
        return attribute.name();
    }

    @Override
    public MemberRoleCode convertToEntityAttribute(String dbData) {
        return MemberRoleCode.valueOf(dbData);
    }
}
