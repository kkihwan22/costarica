package me.kkihwan.web.member.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

@Converter
public class AccountStatusConverter implements AttributeConverter<AccountStatus, String> {
    @Override
    public String convertToDatabaseColumn(AccountStatus attribute) {
        return attribute.name();
    }

    @Override
    public AccountStatus convertToEntityAttribute(String dbData) {
        return Optional.ofNullable(dbData).isPresent() ? AccountStatus.valueOf(dbData) : null;
    }
}