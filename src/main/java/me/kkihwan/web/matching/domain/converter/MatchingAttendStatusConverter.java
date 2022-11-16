package me.kkihwan.web.matching.domain.converter;

import me.kkihwan.web.matching.domain.MatchingAttendStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class MatchingAttendStatusConverter implements AttributeConverter<MatchingAttendStatus, String> {
    @Override
    public String convertToDatabaseColumn(MatchingAttendStatus attribute) {
        return attribute.name();
    }

    @Override
    public MatchingAttendStatus convertToEntityAttribute(String dbData) {
        return MatchingAttendStatus.valueOf(dbData);
    }
}
