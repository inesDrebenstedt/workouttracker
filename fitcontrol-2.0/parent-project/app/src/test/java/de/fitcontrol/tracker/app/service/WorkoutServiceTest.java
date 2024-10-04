package de.fitcontrol.tracker.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import de.fitcontrol.app.App;
import de.fitcontrol.enums.RepCategory;
import de.fitcontrol.enums.WeightUnit;
import de.fitcontrol.model.Exercise;
import de.fitcontrol.model.ExerciseSet;
import de.fitcontrol.model.Rep;
import de.fitcontrol.model.Workout;
import de.fitcontrol.model.WorkoutExercise;
import de.fitcontrol.service.WorkoutService;
import de.fitcontrol.service.ports.ExerciseRepository;
import de.fitcontrol.service.ports.WorkoutExerciseRepository;
import de.fitcontrol.service.ports.WorkoutRepository;

@SpringBootTest(classes = App.class)
@ActiveProfiles("test")  
public class WorkoutServiceTest {
	
	@Autowired
	private WorkoutService workoutService;
	
	@Autowired
	private WorkoutRepository workoutRepo;
	
	@Autowired
	private ExerciseRepository exerciseRepo;
	

	@Autowired
	private WorkoutExerciseRepository workoutExerciserepo;
	
	
	
	@Test
	void testCreateWorkout() {		
		int numberOfWorkouts = workoutRepo.findAll().size();	
		
		List<Exercise> exercises = exerciseRepo.findAll();
		
		Set<Rep> reps1 = new HashSet<>();
		
		for(int i = 0; i < 10; i++) {
			reps1.add(Rep.builder().category(RepCategory.full_ROM).build());
		}
		
		ExerciseSet set1 = ExerciseSet.builder()
				.unit(WeightUnit.kg)
				.weight(10.0)
				.description("set 1 description")
				.reps(reps1)
				.build();
		

		
		Set<Rep> reps2 = new HashSet<>();
		
		for(int i = 0; i < 10; i++) {
			reps2.add(Rep.builder().category(RepCategory.full_ROM).build());
		}
		
		ExerciseSet set2 = ExerciseSet.builder()
				.unit(WeightUnit.kg)
				.weight(10.0)
				.description("set 2 description")
				.reps(reps2)
				.build();
		


       
        WorkoutExercise workoutExercise1 = WorkoutExercise.builder()
        		.referencedExercise(exercises.get(0))
        		.title("workoutExercise1")
        		.sets(List.of(set1))
        		.build();
        
		//workoutExerciserepo.save(workoutExercise1);
        
        WorkoutExercise workoutExercise2 = WorkoutExercise.builder()
        		.referencedExercise(exercises.get(1))
        		.title("workoutExercise2")
        		.sets(List.of(set2))
        		.build();
		
		//workoutExerciserepo.save(workoutExercise2);
		
		Workout newWorkout = Workout.builder()
				.date(LocalDateTime.now())
				.duration(Duration.ofHours(1L))
				.title("TestWorkout1")
				.workoutexercises(List.of(workoutExercise1, workoutExercise2))
				.build();
		
		workoutService.createWorkout(newWorkout);
		assertEquals(numberOfWorkouts+1, workoutRepo.findAll().size());
	}
	
	@Test
	void testUpdateWorkout() {		
		int numberOfWorkouts = workoutRepo.findAll().size();
		List<Workout> workouts = workoutRepo.findAll();
		
		Workout workoutToUpdate = workouts.get(0);
		workoutToUpdate.setTitle("NewTestTitle");
		workoutService.updateWorkout(workoutToUpdate);
		
		assertEquals("NewTestTitle", workoutRepo.findById(workoutToUpdate.getId()).get().getTitle());
		assertEquals(numberOfWorkouts, workoutRepo.findAll().size());
	}
	
	@Test
	void testDeleteWorkout() {		
		int numberOfWorkouts = workoutRepo.findAll().size();
		Workout newWorkout = Workout.builder()
				.date(LocalDateTime.now())
				.duration(Duration.ofHours(1L))
				.title("TestWorkout")
				.build();
		workoutService.createWorkout(newWorkout);
		assertEquals(numberOfWorkouts+1, workoutRepo.findAll().size());
		
		List<Workout> workouts = workoutRepo.findAll();
        Optional<Workout> workoutToDeleteOpt = workouts.stream()
                .filter(foo -> foo.getTitle() == "TestWorkout2") 
                .findFirst();
		
		workoutService.deleteWorkoutById(workoutToDeleteOpt.get().getId());
		assertEquals(numberOfWorkouts, workoutRepo.findAll().size());
	}

}
