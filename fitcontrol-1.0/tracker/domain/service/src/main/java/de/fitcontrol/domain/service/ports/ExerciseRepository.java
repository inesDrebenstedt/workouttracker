package de.fitcontrol.domain.service.ports;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import de.fitcontrol.domain.model.Exercise;

@Repository
public interface ExerciseRepository extends MongoRepository<Exercise, String>{
	
	@Override
	List<Exercise> findAll();

}
