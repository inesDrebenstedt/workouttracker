package de.fitcontrol.domain.service.ports;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import de.fitcontrol.domain.model.Workout;

@Repository
public interface WorkoutRepository extends MongoRepository<Workout, String>{

	
	@Override
	List<Workout> findAll();
	
}
