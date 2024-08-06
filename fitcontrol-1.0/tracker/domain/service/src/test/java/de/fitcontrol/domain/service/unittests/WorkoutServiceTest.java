package de.fitcontrol.domain.service.unittests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import de.fitcontrol.domain.model.Exercise;
import de.fitcontrol.domain.model.ExerciseSet;
import de.fitcontrol.domain.model.Rep;
import de.fitcontrol.domain.model.Workout;
import de.fitcontrol.domain.model.enums.RepCategory;
import de.fitcontrol.domain.service.TestDataMocks;
import de.fitcontrol.domain.service.WorkoutService;
import de.fitcontrol.domain.service.ports.WorkoutRepository;

@ExtendWith(MockitoExtension.class)
public class WorkoutServiceTest {
	
	
    @Mock
    private WorkoutRepository workoutRepo;

    @InjectMocks
    private WorkoutService workoutService;
    
    Workout workout1;
    Exercise exercise1;
    ExerciseSet set1;
    

    @BeforeEach
    public void setUp() {
		TestDataMocks.clearWorkoutData();
		TestDataMocks.clearRepData();
    	exercise1 = TestDataMocks.getClearedExercise();
    	set1 = TestDataMocks.getClearedExerciseSet("set1");
    	workout1 = TestDataMocks.getClearedWorkout("workout1");
    }
    
    // REQ-WORKOUT-BE-1.1
    @Test
    void testCreateWorkout() {
    	Workout newWorkout = workoutService.createWorkout(workout1);
    	
    	verify(workoutRepo).save(newWorkout);
    	TestDataMocks.saveWorkout(newWorkout);
    	when(workoutRepo.findById(newWorkout.getId()))
		.thenReturn(Optional.of(TestDataMocks.getSavedWorkoutById(newWorkout.getId())));

    	assertEquals(workoutRepo.findById(newWorkout.getId()).get().getId(), workout1.getId());
    }
    
    // REQ-WORKOUT-BE-1.2
    @Test
    void testAddExercise () {
    	Workout newWorkout = workoutService.createWorkout(workout1);
    	newWorkout.addExercise(exercise1);
    	TestDataMocks.saveWorkout(newWorkout);
    	
    	assertEquals(1, TestDataMocks.getSavedWorkoutById(newWorkout.getId())
    			.getExercises().size());
    	assertEquals(exercise1.getTitle(), TestDataMocks.getSavedWorkoutById(newWorkout.getId())
    			.getExercises().get(exercise1.getId()).getTitle());
    }
    
    // REQ-WORKOUT-BE-1.3
    @Test
    void testAddExerciseSet () {
    	
    	Workout newWorkout = workoutService.createWorkout(workout1);    	
    	TestDataMocks.saveWorkout(newWorkout);
    	
    	assertEquals(0, TestDataMocks.getSavedWorkoutById(newWorkout.getId())
    			.getExercises().size());
    	newWorkout = TestDataMocks.getSavedWorkoutById(newWorkout.getId());
    	Exercise newExercise = TestDataMocks.getClearedBicepsExercise("bicepsExercise");
    	newWorkout.addExercise(newExercise);
    	TestDataMocks.saveWorkout(newWorkout);
    	
    	assertEquals(0, TestDataMocks.getSavedWorkoutById(newWorkout.getId())
    			.getExercises().get(newExercise.getId())
    			.getSets().size());

    	newWorkout.addExerciseSet(newExercise, set1);
    	TestDataMocks.saveWorkout(newWorkout);
    	
    	assertEquals(1, TestDataMocks.getSavedWorkoutById(newWorkout.getId())
    			.getExercises().get(newExercise.getId())
    			.getSets().size());
    	assertEquals(set1.getId(), TestDataMocks.getSavedWorkoutById(newWorkout.getId())
    			.getExercises().get(newExercise.getId())
    			.getSets().get(set1.getId()).getId());
    }
    
    // REQ-WORKOUT-BE-1.4
    @Test
    void testAddExerciseRep () {
   	
    	//1. create workout with initially 0 Exercises:
    	Workout newWorkout = workoutService.createWorkout(workout1);
    	TestDataMocks.saveWorkout(newWorkout);
    	assertEquals(0, TestDataMocks.getSavedWorkoutById(newWorkout.getId())
    			.getExercises().size());
    	//2. add 1 exercise with initially 0 sets:
    	newWorkout.addExercise(exercise1);
    	TestDataMocks.saveWorkout(newWorkout);
    	assertEquals(1, TestDataMocks.getSavedWorkoutById(newWorkout.getId())
    			.getExercises().size());
    	assertEquals(0, TestDataMocks.getSavedWorkoutById(newWorkout.getId())
    			.getExercises().get(exercise1.getId())
    			.getSets().size());
    	//3. add 1 set with 0 reps to the exercise:
    	newWorkout.addExerciseSet(exercise1, set1);
    	TestDataMocks.saveWorkout(newWorkout);
    	assertEquals(1, TestDataMocks.getSavedWorkoutById(newWorkout.getId())
    			.getExercises().get(exercise1.getId())
    			.getSets().size());
    	assertEquals(0, TestDataMocks.getSavedWorkoutById(newWorkout.getId())
    			.getExercises().get(exercise1.getId())
    			.getSets().get(set1.getId())
    			.getReps().size());
    	//4. add 12 reps to the set previously given to the exercise:
    	newWorkout.addReps(set1, TestDataMocks.getRepsList());
    	assertEquals(12, TestDataMocks.getSavedWorkoutById(newWorkout.getId())
    			.getExercises().get(exercise1.getId())
    			.getSets().get(set1.getId()).getReps().size());

    }
    
    // REQ-WORKOUT-BE-1.5
    @Test
    void testUpdateReps () {
    	Workout newWorkout = workoutService.createWorkout(workout1);
    	newWorkout.addExercise(exercise1);
    	newWorkout.addExerciseSet(exercise1, set1);
    	newWorkout.addReps(set1, TestDataMocks.getRepsList());
    	TestDataMocks.saveWorkout(newWorkout);

    	assertEquals(12, TestDataMocks.getSavedWorkoutById(newWorkout.getId()).getExercises().get(exercise1.getId()).getSets().get(set1.getId()).getReps().size());
    	Rep newRep = Rep.builder()
    			.category(RepCategory.eccentric_partial)
    			.build();
    	newWorkout.addReps(set1, Set.of(newRep));
    	assertEquals(13, TestDataMocks.getSavedWorkoutById(newWorkout.getId()).getExercises().get(exercise1.getId()).getSets().get(set1.getId()).getReps().size());
    	newWorkout.deleteReps(set1, Set.of(newRep));
    	assertEquals(12, TestDataMocks.getSavedWorkoutById(newWorkout.getId()).getExercises().get(exercise1.getId()).getSets().get(set1.getId()).getReps().size());
    //TODO warum geht das hier ohne TestDataMocks.saveWorkout(newWorkout);?
    }
    
    // REQ-WORKOUT-BE-1.6
    @Test
    void testUpdateExerciseDescription() {
    	Workout newWorkout = workoutService.createWorkout(workout1);
    	newWorkout.addExercise(exercise1);
    	newWorkout.addExerciseSet(exercise1, set1);
    	newWorkout.addReps(set1, TestDataMocks.getRepsList());
    	TestDataMocks.saveWorkout(newWorkout);
    	assertEquals(1, TestDataMocks.getSavedWorkoutById(newWorkout.getId())
    			.getExercises().size());
    	assertEquals(1, TestDataMocks.getSavedWorkoutById(newWorkout.getId())
    			.getExercises().get(exercise1.getId())
    			.getSets().size());
    	assertEquals(12, TestDataMocks.getSavedWorkoutById(newWorkout.getId())
    			.getExercises().get(exercise1.getId())
    			.getSets().get(set1.getId())
    			.getReps().size());
    	TestDataMocks.saveWorkout(newWorkout);
    	
    	exercise1.setDescription("new description");
    	newWorkout.updateExercise(exercise1);
    	assertEquals("new description", TestDataMocks.getSavedWorkoutById(workout1.getId()).getExercises().get(exercise1.getId()).getDescription());
    }
    
    // REQ-WORKOUT-BE-1.7
    @Test
    void testDeleteExerciseSet () {
    	Workout newWorkout = workoutService.createWorkout(workout1);
    	newWorkout.addExercise(exercise1);
    	newWorkout.addExerciseSet(exercise1, set1);
    	newWorkout.addReps(set1, TestDataMocks.getRepsList());
    	TestDataMocks.saveWorkout(newWorkout);
    	assertEquals(1, TestDataMocks.getSavedWorkoutById(newWorkout.getId())
    			.getExercises().get(exercise1.getId())
    			.getSets().size());
    	assertEquals(12, TestDataMocks.getSavedWorkoutById(newWorkout.getId())
    			.getExercises().get(exercise1.getId())
    			.getSets().get(set1.getId())
    			.getReps().size());
    	newWorkout.deleteExerciseSet(exercise1, set1);
    	TestDataMocks.saveWorkout(newWorkout);

    	assertEquals(0, TestDataMocks.getSavedWorkoutById(newWorkout.getId())
    			.getExercises().get(exercise1.getId())
    			.getSets().size());
    }
    
    
    // REQ-WORKOUT-BE-1.8
    @Test
    void testDeleteExercise () {
    	Workout newWorkout = workoutService.createWorkout(workout1);
    	newWorkout.addExercise(exercise1);
    	newWorkout.addExerciseSet(exercise1, set1);
    	newWorkout.addReps(set1, TestDataMocks.getRepsList());
    	TestDataMocks.saveWorkout(newWorkout);
    	assertEquals(1, TestDataMocks.getSavedWorkoutById(newWorkout.getId())
    			.getExercises().size());
    	assertEquals(1, TestDataMocks.getSavedWorkoutById(newWorkout.getId())
    			.getExercises().get(exercise1.getId())
    			.getSets().size());
    	assertEquals(12, TestDataMocks.getSavedWorkoutById(newWorkout.getId())
    			.getExercises().get(exercise1.getId())
    			.getSets().get(set1.getId())
    			.getReps().size());
    	newWorkout.deleteExercise(exercise1);
    	TestDataMocks.saveWorkout(newWorkout);

    	assertEquals(0, TestDataMocks.getSavedWorkoutById(newWorkout.getId())
    			.getExercises().size());
    }
    
    
    // REQ-WORKOUT-BE-1.9
    @Test
    void testDeleteWorkout () {
    	Workout newWorkout = workoutService.createWorkout(workout1);
    	newWorkout.addExercise(exercise1);
    	newWorkout.addExerciseSet(exercise1, set1);
    	newWorkout.addReps(set1, TestDataMocks.getRepsList());
    	TestDataMocks.saveWorkout(newWorkout);
    	assertEquals(1, TestDataMocks.getSavedWorkoutById(newWorkout.getId())
    			.getExercises().size());
    	assertEquals(1, TestDataMocks.getSavedWorkoutById(newWorkout.getId())
    			.getExercises().get(exercise1.getId())
    			.getSets().size());
    	assertEquals(12, TestDataMocks.getSavedWorkoutById(newWorkout.getId())
    			.getExercises().get(exercise1.getId())
    			.getSets().get(set1.getId())
    			.getReps().size());
    	TestDataMocks.saveWorkout(newWorkout);
    	
    	workoutService.deleteWorkoutById(newWorkout.getId());
    	verify(workoutRepo).deleteById(newWorkout.getId());
    }

}
