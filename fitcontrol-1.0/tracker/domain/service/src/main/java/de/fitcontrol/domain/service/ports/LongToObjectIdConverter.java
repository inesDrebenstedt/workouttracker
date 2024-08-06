package de.fitcontrol.domain.service.ports;

import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

@Component
@WritingConverter
public class LongToObjectIdConverter implements Converter<Long, ObjectId> {
    @Override
    public ObjectId convert(Long source) {
        return new ObjectId(source.toString()); // or any other logic to convert Long to ObjectId
    }
}
