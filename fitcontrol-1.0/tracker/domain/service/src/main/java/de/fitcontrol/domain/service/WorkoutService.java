package de.fitcontrol.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.fitcontrol.domain.model.Workout;
import de.fitcontrol.domain.service.ports.WorkoutRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WorkoutService {
	
	@Autowired WorkoutRepository workoutRepo;
	
	public Workout createWorkout(Workout workout) {
		Workout newWorkout = Workout.builder()
				.id(workout.getId())
				.exercises(workout.getExercises())
				.title(workout.getTitle())
				.date(workout.getDate())
				.duration(workout.getDuration()).build();
				
		workoutRepo.save(newWorkout);
		return newWorkout;
	}
	
	public void deleteWorkoutById(String workoutId) {
		workoutRepo.deleteById(workoutId);
	}
	
	public void updateWorkout(Workout workout) {
		workoutRepo.save(workout);
	}

//	public Optional<Workout> showWorkout(Long workoutId) {
//		return workoutRepo.findById(workoutId);				
//	}

	public void saveWorkout(Workout workout) {
		workoutRepo.save(workout);
	}

}
