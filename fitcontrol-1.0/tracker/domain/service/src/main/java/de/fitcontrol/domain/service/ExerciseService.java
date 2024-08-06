package de.fitcontrol.domain.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.fitcontrol.domain.model.Exercise;
import de.fitcontrol.domain.model.Workout;
import de.fitcontrol.domain.service.ports.ArrayListToMapConverter;
import de.fitcontrol.domain.service.ports.ExerciseRepository;

@Service
public class ExerciseService {

	@Autowired ExerciseRepository exerciseRepo;
	
	public Exercise createExercise(Exercise exercise) {
		Exercise newExercise = Exercise.builder()
				.sets(exercise.getSets())
				.title(exercise.getTitle())
				.primaryMuscleGroups(exercise.getPrimaryMuscleGroups())
				.secondaryMuscleGroups(exercise.getSecondaryMuscleGroups()).build();
		
		exerciseRepo.save(newExercise);
		return newExercise;		
	}

	public void updateExercise(Exercise exercise) {
		exerciseRepo.save(exercise);
	}

	public void deleteExercise(String exerciseId) {
		exerciseRepo.deleteById(exerciseId);		
	}
	
	public List<Exercise> showAllExercisesFromDB() {
		return exerciseRepo.findAll();
	}

	public Map<String, Exercise> showAllExercisesOf(Workout workout) {
		return workout.getExercises();
	}

	public Optional<Exercise> showExercise(String exerciseId) {
		return exerciseRepo.findById(exerciseId);
	}

}
