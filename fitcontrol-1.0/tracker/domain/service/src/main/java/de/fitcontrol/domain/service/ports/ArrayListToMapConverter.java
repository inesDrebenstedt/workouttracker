package de.fitcontrol.domain.service.ports;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import de.fitcontrol.domain.model.Exercise;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ArrayListToMapConverter implements Converter<List<Exercise>, Map<String, Exercise>> {

    @Override
    public Map<String, Exercise> convert(List<Exercise> source) {
    	log.warn("============================> !2!");
        Map<String, Exercise> map = new HashMap<>();
        source.forEach(exercise -> map.put(exercise.getId(), exercise));
        return map;
    }
    
}
