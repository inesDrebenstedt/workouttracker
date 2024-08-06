import { Component, OnInit } from '@angular/core';
import { ExerciseService } from 'src/app/shared/services/exercise.service'; 
import { ActivatedRoute } from '@angular/router';
import { Exercise } from 'src/app/core/model/exercise';


@Component({
  selector: 'app-exercise-list',
  templateUrl: './exercise-list.component.html',
  styleUrls: ['./exercise-list.component.scss']
})
export class ExerciseListComponent {

  constructor(private exerciseService: ExerciseService, private route: ActivatedRoute) { }
  exercises: Exercise[] | undefined;

  navbarTitle: string = 'List of Exercises';

  ngOnInit(): void {
    console.log('inside ngOnInit() of WorkoutListComponent');

    this.exerciseService.getExercises().subscribe(data => {
      this.exercises = data;
      console.log('call to BE: ' + this.exercises.length);
      this.exercises.forEach(exercise => console.log('---> ' + exercise.title));
    });

  }

  onTileClick() {

  }

}
