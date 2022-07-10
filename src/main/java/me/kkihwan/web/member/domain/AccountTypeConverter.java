package me.kkihwan.web.member.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

@Converter
public class AccountTypeConverter implements AttributeConverter<AccountType, String> {
    @Override
    public String convertToDatabaseColumn(AccountType attribute) {
        return attribute.name();
    }

    @Override
    public AccountType convertToEntityAttribute(String dbData) {
        return Optional.ofNullable(dbData).isPresent() ? AccountType.valueOf(dbData) : null;
    }
}