package ru.tisbi.college.model;

import java.time.Year;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class YearAttributeConverter implements AttributeConverter<Year, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Year attribute) {
        if (attribute != null) {
            return attribute.getValue();
        }
        return null;
    }

    @Override
    public Year convertToEntityAttribute(Integer dbData) {
        if (dbData != null) {
            return Year.of(dbData);
        }
        return null;
    }

}
