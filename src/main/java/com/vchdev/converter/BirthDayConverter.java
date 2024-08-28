package com.vchdev.converter;

import com.vchdev.dao.entity.BirthDay;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.sql.Date;

@Converter(autoApply = true)
public class BirthDayConverter implements AttributeConverter<BirthDay, Date> {
    @Override
    public Date convertToDatabaseColumn(BirthDay attribute) {
        return attribute != null ? Date.valueOf(attribute.birthDate()) : null;
    }

    @Override
    public BirthDay convertToEntityAttribute(Date dbData) {
        if (dbData == null) {
            return null;
        }
        return new BirthDay(dbData.toLocalDate());
    }
}
