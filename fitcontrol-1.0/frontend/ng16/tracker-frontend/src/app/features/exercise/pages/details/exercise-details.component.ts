import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Exercise } from 'src/app/core/model/exercise';
import { ExerciseService } from 'src/app/shared/services/exercise.service';

@Component({
  selector: 'app-exercise-details',
  templateUrl: './exercise-details.component.html',
  styleUrls: ['./exercise-details.component.scss']
})
export class ExerciseDetailsComponent {

  constructor(
    //private workoutService: WorkoutService, 
    private exerciseService: ExerciseService, 
    private route: ActivatedRoute,
    private router: Router,

  ) { }

  navbarTitle: string = 'default workout navbar title';
  exercise: Exercise | undefined;


  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      console.log('... ' + params)
      const id = params['exerciseId'];
      if (id) {
        console.log('-------------------> exercise id: ' + id);

        this.exerciseService.getExercise(id).subscribe(data => {
          this.exercise = data;
          this.navbarTitle = 'TODO 2 !';
          console.log('-------------------> exercise: ' + JSON.stringify( this.exercise, null, 2));

        });
      }
    });
  }

}
