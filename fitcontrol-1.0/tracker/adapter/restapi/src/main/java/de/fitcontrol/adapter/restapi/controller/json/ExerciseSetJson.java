package de.fitcontrol.adapter.restapi.controller.json;

import java.util.ArrayList;
import java.util.List;

import de.fitcontrol.domain.model.Exercise;
import de.fitcontrol.domain.model.ExerciseSet;
import de.fitcontrol.domain.model.Rep;
import de.fitcontrol.domain.model.Workout;
import de.fitcontrol.domain.model.enums.WeightUnit;

public class ExerciseSetJson {
	
	private String id;
	private Double weight;
	private WeightUnit unit;
	private List<RepJson> reps;
	private String description;
	private Integer numberOfReps;
	private ExerciseJson exercise;
	
	public ExerciseSetJson(ExerciseSet exerciseSet) {
		this.id = exerciseSet.getId();
		this.weight = exerciseSet.getWeight();
		this.unit = exerciseSet.getUnit();
		//TODO this.reps = RepJson.from(exerciseSet.getReps());
		this.description = exerciseSet.getDescription();
		this.numberOfReps = exerciseSet.getNumberOfReps().SIZE;
		this.exercise = ExerciseJson.from(exerciseSet.getExercise());
	}
	
	public static ExerciseJson from(Exercise exercise) {
		return new ExerciseJson(exercise);
	}

	public static List<ExerciseJson> from(List<Exercise> exercises) {
		List<ExerciseJson> exercisesJson = new ArrayList<>();
		exercises.forEach(e -> exercisesJson.add(new ExerciseJson(e)));
		return exercisesJson;
	}

	public static List<ExerciseJson> from(Workout workout) {
		//TODO return from(workout.getExercises());
		return null;
	}
}
