import { Component, OnInit } from '@angular/core';
import { WorkoutService } from 'src/app/shared/services/workout.service';
import { ActivatedRoute } from '@angular/router';
import { Workout } from 'src/app/core/model/workout';
import { Exercise } from 'src/app/core/model/exercise';
import { ExerciseSet } from 'src/app/core/model/exercise-set';
import { ExerciseService } from 'src/app/shared/services/exercise.service';
import { Router,   } from '@angular/router';



@Component({
  selector: 'app-workout-detail',
  templateUrl: './workout-detail.component.html',
  styleUrls: ['./workout-detail.component.scss']
})
export class WorkoutDetailComponent implements OnInit {

  constructor(
    private workoutService: WorkoutService, 
    private exerciseService: ExerciseService, 
    private route: ActivatedRoute,
    private router: Router,

  ) { }

 navbarTitle: string = 'default workout navbar title';
 workout: Workout | undefined;

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      const id = params['workoutId'];
      if (id) {
        console.log('-------------------> workout id: ' + id);
        this.workoutService.getWorkout(id).subscribe(data => {
          this.workout = data;
          this.navbarTitle = 'TODO 1 !';
          console.log('-------------------> workout: ' + this.workout.title);
        });
      }
    });
  }

/*
  chooseExercise(): Exercise {
    this.router.navigate(['exercise/all']);

  }
    */

  addExercise(): void {
    let idNum = 0;
    let exerciseSet = null;
    if(this.workout){
      idNum = this.workout.exercises.length + 1; 
      
    }

    let newExercise: Exercise = {
      id: 'idNum',
      title: '',
      description: '',
      primaryMuscleGroups: [],
      secondaryMuscleGroups: [],
      sets: []
    };
 
    //const newExercise = new Exercise('2', 'Sample Title 2', 'Sample Description 2');
      //this.workoutService.
  }

}
