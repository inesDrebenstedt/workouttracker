package de.fitcontrol.adapter.restapi.controller;

import java.sql.SQLException;
import java.util.Map;

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
import de.fitcontrol.domain.model.ExerciseSet;
import de.fitcontrol.domain.service.ExerciseSetService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping(value = "/exerciseset", produces = { "application/json" })
public class ExerciseSetController {
	
	@Autowired ExerciseSetService exerciseSetService;

	
	@ApiResponse(responseCode = "200", description = "OK")
	@PostMapping("/create")
	public ResponseEntity<?> createExerciseSet(@RequestBody Exercise exercise) {
		exerciseSetService.createExerciseSet();//TODO
			return ResponseEntity.ok().build();
	}

	@PutMapping("/update")
	public void updateExerciseSet(@RequestBody ExerciseSet exerciseSet) {
		exerciseSetService.updateExerciseSet(exerciseSet);
	}

	@ApiResponse(responseCode = "400", description = "Seriennummer fehlt")
	@DeleteMapping("/delete")
	public void delete(@RequestParam String exerciseId) throws SQLException {
		exerciseSetService.deleteExerciseSet(exerciseId);
	}

	@ApiResponse(responseCode = "200", description = "OK")
	@GetMapping("/allofexercise")
	public Map<String, ExerciseSet> showAllExerciseSetsOf(Exercise exercise) {
		return exercise.getSets();
	}
	

}
