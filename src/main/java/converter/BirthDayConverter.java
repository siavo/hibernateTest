package converter;

import entity.BirthDay;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;

@Converter(autoApply = true)
public class BirthDayConverter implements AttributeConverter<BirthDay, Date> {
    @Override
    public Date convertToDatabaseColumn(BirthDay attribute) {
        return Date.valueOf(attribute.birthDate());
    }

    @Override
    public BirthDay convertToEntityAttribute(Date dbData) {
        return new BirthDay(dbData.toLocalDate());
    }
}
