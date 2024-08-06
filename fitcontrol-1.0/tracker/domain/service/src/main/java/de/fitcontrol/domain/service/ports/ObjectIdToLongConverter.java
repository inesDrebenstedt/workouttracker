package de.fitcontrol.domain.service.ports;

import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

@Component
@ReadingConverter
public class ObjectIdToLongConverter implements Converter<ObjectId, Long> {
    @Override
    public Long convert(ObjectId source) {
        return (long) source.getTimestamp(); // or any other logic to convert ObjectId to Long
    }
}



