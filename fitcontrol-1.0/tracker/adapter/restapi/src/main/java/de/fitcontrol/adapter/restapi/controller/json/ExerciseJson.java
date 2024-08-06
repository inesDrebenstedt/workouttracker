package de.fitcontrol.adapter.restapi.controller.json;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.fitcontrol.domain.model.Exercise;
import de.fitcontrol.domain.model.ExerciseSet;
import de.fitcontrol.domain.model.Workout;
import de.fitcontrol.domain.model.enums.MuscleGroup;

public class ExerciseJson {
	
	private String id;
	private Map<String, ExerciseSet> sets;
	private String title;
	private List<MuscleGroup> primaryMuscleGroups;
	private List<MuscleGroup> secondaryMuscleGroups;
	
	
	public ExerciseJson(Exercise exercise) {
		this.id = exercise.getId();
		this.sets = exercise.getSets();
		this.title = exercise.getTitle();
		this.primaryMuscleGroups = exercise.getPrimaryMuscleGroups();
		this.secondaryMuscleGroups = exercise.getSecondaryMuscleGroups();
	}
	
	public static ExerciseJson from(Exercise exercise) {
		return new ExerciseJson(exercise);
	}

	public static List<ExerciseJson> from(List<Exercise> exercises) {
		List<ExerciseJson> exercisesJson = new ArrayList<>();
		if(exercisesJson.size() > 0) {
			exercises.forEach(e -> exercisesJson.add(new ExerciseJson(e)));
		}
		return exercisesJson;
	}

	public static List<ExerciseJson> from(Workout workout) {
		return null; //from(workout.getExercises()); //TODO
	}
	

}
