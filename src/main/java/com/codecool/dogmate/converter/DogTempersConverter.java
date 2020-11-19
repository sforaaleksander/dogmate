package com.codecool.dogmate.converter;

import com.codecool.dogmate.model.DogTempers;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class DogTempersConverter implements AttributeConverter<DogTempers, Long> {

    @Override
    public Long convertToDatabaseColumn(DogTempers temper) {
        if (temper == null) {
            return null;
        }
        return temper.getId();
    }

    @Override
    public DogTempers convertToEntityAttribute(Long code) {
        if (code == null) {
            return null;
        }

        return Stream.of(DogTempers.values())
                .filter(c -> c.getId().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
