package me.kkihwan.web.shared.domain.converter;

import javax.persistence.*;

@Converter
public class BooleanToCharConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        return (attribute != null && attribute)
                ? "Y"
                : "N";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        return "Y".equalsIgnoreCase(dbData);
    }
}