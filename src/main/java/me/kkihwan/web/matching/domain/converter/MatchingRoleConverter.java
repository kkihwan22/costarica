package me.kkihwan.web.matching.domain.converter;

import me.kkihwan.web.matching.domain.MatchingRole;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class MatchingRoleConverter implements AttributeConverter<MatchingRole, String> {
    @Override
    public String convertToDatabaseColumn(MatchingRole attribute) {
        return attribute.name();
    }

    @Override
    public MatchingRole convertToEntityAttribute(String dbData) {
        return MatchingRole.valueOf(dbData);
    }
}
