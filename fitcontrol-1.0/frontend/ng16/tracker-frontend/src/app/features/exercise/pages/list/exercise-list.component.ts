import { Component, OnInit } from '@angular/core';
import { ExerciseService } from 'src/app/shared/services/exercise.service'; 
import { ActivatedRoute } from '@angular/router';
import { Exercise } from 'src/app/core/model/exercise';
import { Router,  } from '@angular/router';


@Component({
  selector: 'app-exercise-list',
  templateUrl: './exercise-list.component.html',
  styleUrls: ['./exercise-list.component.scss']
})
export class ExerciseListComponent {

  constructor(
    private exerciseService: ExerciseService, 
    private route: ActivatedRoute,
    private router: Router
  ) { }
  
  navbarTitle: string = 'List of Exercises TODO';
  exercises: Exercise[] | undefined;

  ngOnInit(): void {
    this.exerciseService.getExercises().subscribe(data => {
      this.exercises = data;
    });

  }

  onTileClick(exerciseId: String): void {
    this.router.navigate(['exercise/singleexercise'], 
      { queryParams: { exerciseId: exerciseId } });
  }



}
