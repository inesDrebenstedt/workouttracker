package de.fitcontrol.domain.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import de.fitcontrol.domain.model.Exercise;
import de.fitcontrol.domain.model.ExerciseSet;
import de.fitcontrol.domain.model.Rep;
import de.fitcontrol.domain.model.Workout;
import de.fitcontrol.domain.model.enums.MuscleGroup;
import de.fitcontrol.domain.model.enums.RepCategory;
import de.fitcontrol.domain.model.enums.WeightUnit;

public class TestDataMocks {
	
	public static Set<Rep> repsMockLIst = new HashSet<>();
	
	public static void initializeReps () {
		for (int i = 1; i < 13; i++ ) {
			repsMockLIst.add(
					Rep.builder()
					.category(RepCategory.full_ROM)
					.build()
					);
		}
	}
	
	public static Set<Rep> getRepsList () {
		initializeReps ();
		return repsMockLIst;
	}
	
	
	public static Map<String, ExerciseSet> exerciseSetMockList = new HashMap<>();
	
	public static void initializeExerciseSetMockList(Optional<Exercise> exercise) {
		for (int i = 1; i < 4; i++ ) {
			exerciseSetMockList.put(
					"exerciseSet" + String.valueOf(i),
					ExerciseSet.builder()
					.description("exerciseSet" + String.valueOf(i) + " test description")
					.exercise(exercise.get())
					.id("ExerciseSet"+i)
					.numberOfReps(12)
					.unit(WeightUnit.kg)
					.weight(2.0)
					.build()
					);
			//initially, when a new Exercise set is created, it has zero reps.
			//reps are only to be created when the Exercise set already exists.
		}
	}
	
	public static Map<String, ExerciseSet> getClearedExerciseSetList (Optional<Exercise> exercise) {
		initializeExerciseSetMockList(exercise);
		
		return exerciseSetMockList;
	}
	
	
	public static Exercise getClearedExercise() {
		return Exercise.builder()
				.id("zottmanCurls")
				.primaryMuscleGroups(List.of(MuscleGroup.Biceps_Brachialis, MuscleGroup.Biceps_Brachioradialis))
				.secondaryMuscleGroups(List.of(MuscleGroup.Flexor_Digitorum))
				.title("zottmanCurls")
				.build();
		//initially created, a new exercise set has no rep count yet
	}
	
	
	public static ExerciseSet getClearedExerciseSet(String identifier) {
		return ExerciseSet.builder()
				.id(identifier)
				.description(identifier+"Description")
				.numberOfReps(12)
				.weight(10.0)
				.unit(WeightUnit.kg)
				.build();
	}

	
	public static Workout getClearedWorkout(String identifier) {
		Workout workoutMock1 = Workout.builder()
				.id(identifier)
				.title(identifier+"Title")
				.date(LocalDateTime.now())
				.duration(Duration.ofHours(1L))
				.build();
		return workoutMock1;
		//When new workout is created, it initially has no exercises.
	}
	
	public static Exercise getClearedBicepsExercise (String identifier) {
		Exercise  exercise = 
				Exercise.builder()
				.id(identifier)
				.primaryMuscleGroups(List.of(MuscleGroup.Biceps_Brachialis, MuscleGroup.Biceps_Brachioradialis))
				.secondaryMuscleGroups(List.of(MuscleGroup.Flexor_Digitorum))
				.title(identifier+"Title")
				.build();
				
		return exercise;
	}
	
	public static Map<String, Workout> wourkoutsInDBMock = new HashMap<>();
		
	public static void saveWorkout(Workout workout) {
		System.out.println("--------------------------> WORKOUT saved: " + workout.getId());
		wourkoutsInDBMock.put(workout.getId(), workout);
	}
	
	public static Workout getSavedWorkoutById(String workoutId) {
		return wourkoutsInDBMock.get(workoutId);
	}
	
	public static void deleteSavedWorkout(String workoutId) {
		if (wourkoutsInDBMock.containsKey(workoutId)) {
			wourkoutsInDBMock.remove(workoutId);
			System.out.println("--------------------------> WORKOUT deleted: " + workoutId);
		}
	}
	
	public static void clearWorkoutData() {
		wourkoutsInDBMock = new HashMap<>();
	}
	
	public static void clearRepData() {
		repsMockLIst = new HashSet<>();
	}
	
}
