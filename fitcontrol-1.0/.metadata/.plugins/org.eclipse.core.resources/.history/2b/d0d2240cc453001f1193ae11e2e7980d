package de.fitcontrol.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.fitcontrol.domain.model.Exercise;
import de.fitcontrol.domain.model.ExerciseSet;
import de.fitcontrol.domain.model.Workout;
import de.fitcontrol.domain.service.ports.ExerciseRepository;

@Service
public class ExerciseSetService {
	
	@Autowired ExerciseRepository exerciseRepo;
	
	public ExerciseSet createExerciseSet() {//TODO input params: Workout workout, Exercise exercise, ExerciseSet exerciseSet
		//TODO
		//TODO exerciseRepo.save(exercise);
		return null;			
	}

	public void updateExerciseSet(ExerciseSet exerciseSet) {		
		exerciseRepo.save(exerciseSet.getExercise());
	}

	public void deleteExerciseSet(String exerciseSetId) {
		exerciseRepo.deleteById(exerciseSetId);		
	}
	
	public Iterable<ExerciseSet> showAllExerciseSetsOf(Exercise exercise) {
		return null; //TODO exercise.getSets();
	}

}
