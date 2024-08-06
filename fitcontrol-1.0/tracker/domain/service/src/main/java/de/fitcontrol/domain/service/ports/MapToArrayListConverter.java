package de.fitcontrol.domain.service.ports;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;

import de.fitcontrol.domain.model.Exercise;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MapToArrayListConverter implements Converter <Map<String, Exercise>, List<Exercise>> {
	
	@Override
	public List<Exercise> convert(Map<String, Exercise> source) {
    	log.warn("============================> !3!");
        return new ArrayList<>(source.values());
	}



}
