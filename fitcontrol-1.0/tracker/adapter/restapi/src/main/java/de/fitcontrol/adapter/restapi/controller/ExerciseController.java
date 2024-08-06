package de.fitcontrol.adapter.restapi.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.fitcontrol.domain.model.Exercise;
import de.fitcontrol.domain.model.Workout;
import de.fitcontrol.domain.service.ExerciseService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping(value = "/exercise", produces = { "application/json" })
public class ExerciseController {	

	@Autowired ExerciseService exerciseService;
	
	@ApiResponse(responseCode = "200", description = "OK")
	@PostMapping("/create")
	public ResponseEntity<?> createExercise(@RequestBody Exercise exercise) {
			exerciseService.createExercise(exercise);
			return ResponseEntity.ok().build();
	}

	@PutMapping("/update")
	public void updateExercise(@RequestBody Exercise exercise) {
		exerciseService.updateExercise(exercise);
	}

	@ApiResponse(responseCode = "400", description = "Seriennummer fehlt")
	@DeleteMapping("/delete")
	public void delete(@RequestParam String exerciseId) throws SQLException {
		exerciseService.deleteExercise(exerciseId);
	}

	@ApiResponse(responseCode = "200", description = "OK")
	@GetMapping("/byworkout")
	public Map<String, Exercise> showAllExercisesOf(Workout workout) {
		return workout.getExercises();
	}
	
	@ApiResponse(responseCode = "200", description = "OK")
	@GetMapping("/all")
	public List<Exercise> showAllExercisesFromDB() {
		return exerciseService.showAllExercisesFromDB();
	}
	
	@ApiResponse(responseCode = "200", description = "OK")
	@GetMapping("/singleexercise")
	public Optional<Exercise> showExercise(@RequestParam String exerciseId) {
		return exerciseService.showExercise(exerciseId);
	}


}
