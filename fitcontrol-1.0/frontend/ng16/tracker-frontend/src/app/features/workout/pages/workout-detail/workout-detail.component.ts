import { Component, OnInit } from '@angular/core';
import { WorkoutService } from 'src/app/shared/services/workout.service';
import { ActivatedRoute } from '@angular/router';
import { Workout } from 'src/app/core/model/workout';
import { Exercise } from 'src/app/core/model/exercise';
import { ExerciseService } from 'src/app/shared/services/exercise.service';

@Component({
  selector: 'app-workout-detail',
  templateUrl: './workout-detail.component.html',
  styleUrls: ['./workout-detail.component.scss']
})
export class WorkoutDetailComponent implements OnInit {

 navbarTitle: string = 'single workout';
 workout: Workout | undefined;
 
  constructor(
    private workoutService: WorkoutService, 
    private exerciseService: ExerciseService, 
    private route: ActivatedRoute,

  ) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      const id = params['workoutId'];
      if (id) {
        console.log('-------------------> workout id: ' + id);
        this.workoutService.getWorkoutId(id);

        this.workoutService.getWorkout(id).subscribe(data => {
          this.workout = data;
          this.navbarTitle = 'List of Workouts';
          console.log('-------------------> workout: ' + this.workout.title);
        });
      }
    });
  }


  addExercise(): void {
    const newExercise = new Exercise('2', 'Sample Title 2', 'Sample Description 2');
      this.workoutService.
  }

}
