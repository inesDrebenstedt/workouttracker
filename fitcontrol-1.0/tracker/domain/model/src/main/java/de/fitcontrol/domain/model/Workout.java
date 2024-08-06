package de.fitcontrol.domain.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Document(collection = "workout")
@SuperBuilder
public class Workout {
	
    @Id
    @Getter
    private final String id;
	
	@Setter
	private Map<String, Exercise> exercises;
	
	@Getter
	@Setter
	private String title;
	
	@Getter
	@Setter
	private LocalDateTime date;
	
	@Getter
	@Setter
	private Duration duration;
	
	
	public void addExercise(Exercise exercise) {
		if (this.exercises == null) {
			this.exercises = new HashMap<String, Exercise>();
		}
		this.exercises.put(exercise.getId(), exercise);
	}
	
	public void updateExercise(Exercise updatedExercise) {
        if (this.exercises.containsKey(updatedExercise.getId())) {
        	this.exercises.put(updatedExercise.getId(), updatedExercise);
        } else {
            throw new IllegalArgumentException("..."); //TODO
        }
	}
	
	public void deleteExercise(Exercise updatedExercise) {
        if (this.exercises.containsKey(updatedExercise.getId())) {
        	this.exercises.remove(updatedExercise.getId(), updatedExercise);
        } else {
            throw new IllegalArgumentException("..."); //TODO
        }
	}
	
	public void addExerciseSet(Exercise exercise, ExerciseSet exerciseSet) {
		exercise.getSets().put(exerciseSet.getId(), exerciseSet);
		this.exercises.put(exercise.getId(), exercise);
	}
	
	public void updateExerciseSet(Exercise exercise, ExerciseSet exerciseSet) {
		if (this.exercises.containsKey(exercise.getId())) {
			exercise.getSets().put(exerciseSet.getId(), exerciseSet);
		} else {
			throw new IllegalArgumentException("..."); //TODO
		}
	}
	
	public void deleteExerciseSet(Exercise exercise, ExerciseSet exerciseSet) {
		if (this.exercises.containsKey(exercise.getId())) {
			exercise.getSets().remove(exerciseSet.getId(), exerciseSet);
			// TODO : not necessary: this.exercises.put(exercise.getId(), exercise); ???
		} else {
			throw new IllegalArgumentException("..."); //TODO
		}
	}
	
	public void addReps(ExerciseSet exerciseSet, Set<Rep> reps) {
		exerciseSet.getReps().addAll(reps);
	}
	
	public void deleteReps(ExerciseSet exerciseSet, Set<Rep> reps) {
		exerciseSet.getReps().removeAll(reps);
	}
	
	public Map<String, Exercise> getExercises() {
		if (this.exercises == null) {
			this.exercises = new HashMap<>();
		}
		return exercises;
	}

}
