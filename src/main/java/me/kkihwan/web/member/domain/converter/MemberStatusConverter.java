package me.kkihwan.web.member.domain.converter;

import me.kkihwan.web.member.domain.*;

import javax.persistence.*;

@Converter
public class MemberStatusConverter implements AttributeConverter<MemberStatus, String> {

    @Override
    public String convertToDatabaseColumn(MemberStatus attribute) {
        return attribute.name();
    }

    @Override
    public MemberStatus convertToEntityAttribute(String dbData) {
        return MemberStatus.valueOf(dbData);
    }
}
