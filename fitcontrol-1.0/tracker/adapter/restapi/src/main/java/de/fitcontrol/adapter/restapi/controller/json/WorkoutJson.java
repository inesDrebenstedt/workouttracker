package de.fitcontrol.adapter.restapi.controller.json;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import de.fitcontrol.domain.model.Workout;
import lombok.Getter;

@Getter
public class WorkoutJson {
	
	private String id;
	private List<ExerciseJson> exercises;
	private String title;
	private LocalDateTime date;
	private Duration duration;
	
	public WorkoutJson(Workout workout) {
		this.id = workout.getId();
		//TODO: this.exercises = ExerciseJson.from(workout.getExercises());
		this.title = workout.getTitle();
		this.date = workout.getDate();
		this.duration = workout.getDuration();
	}
	
	public static WorkoutJson from(Workout workout) {
		return new WorkoutJson(workout);
	}
	
	public static List<WorkoutJson> from(List<Workout> workouts) {
		List<WorkoutJson> workoutsJson = new ArrayList<>();
		if(workouts.size() > 0) {
			workouts.forEach(workout -> workoutsJson.add(new WorkoutJson(workout)));
		}
		return workoutsJson;
	}

}
