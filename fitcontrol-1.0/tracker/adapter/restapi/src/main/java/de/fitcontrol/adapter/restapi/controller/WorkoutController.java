package de.fitcontrol.adapter.restapi.controller;

import java.util.List;
import java.util.UUID;

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

import de.fitcontrol.adapter.restapi.controller.json.WorkoutJson;
import de.fitcontrol.domain.model.Workout;
import de.fitcontrol.domain.service.WorkoutService;
import de.fitcontrol.domain.service.ports.WorkoutRepository;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value = "/workout", produces = { "application/json" })
public class WorkoutController {
	
	@Autowired WorkoutService workoutService;
	@Autowired WorkoutRepository workoutRepo;
	
	@ApiResponse(responseCode = "200", description = "OK")
	@PostMapping("/create")
	public ResponseEntity<?> createWorkout(@RequestBody Workout workout) {
			workoutService.createWorkout(workout);
			return ResponseEntity.ok().build();
	}

	@PutMapping("/update")
	public void updateWorkout(@RequestBody Workout workout) {
		workoutService.updateWorkout(workout);
	}

	@ApiResponse(responseCode = "400", description = "Seriennummer fehlt")
	@DeleteMapping("/delete")
	public void delete(@RequestParam String workoutId) {
		workoutService.deleteWorkoutById(workoutId);
	}

	@ApiResponse(responseCode = "200", description = "OK")
	@GetMapping("/all")
	public List<WorkoutJson> showAllWorkouts() {
		return WorkoutJson.from(workoutRepo.findAll());
	}
	
	@ApiResponse(responseCode = "200", description = "OK")
	@GetMapping("/singleworkout")
	public WorkoutJson showWorkout(@RequestParam String workoutId) {
		return WorkoutJson.from(workoutRepo.findById(workoutId).get());
	}
	
	@ApiResponse(responseCode = "200", description = "OK")
	@GetMapping("/save")
	public Workout saveWorkout(@RequestParam Workout workout) {
		return workoutRepo.save(workout);
	}

}
