package me.kkihwan.web.matching.domain.converter;

import me.kkihwan.web.matching.domain.MatchingStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class MatchingStatusConverter implements AttributeConverter<MatchingStatus, String> {
    @Override
    public String convertToDatabaseColumn(MatchingStatus attribute) {
        return attribute.name();
    }

    @Override
    public MatchingStatus convertToEntityAttribute(String dbData) {
        return MatchingStatus.valueOf(dbData);
    }
}
