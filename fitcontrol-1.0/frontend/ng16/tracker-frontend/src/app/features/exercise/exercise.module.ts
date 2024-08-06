import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ExerciseDetailsComponent } from './pages/details/exercise-details.component';
import { ExerciseListComponent } from './pages/list/exercise-list.component';
import { MatGridListModule } from '@angular/material/grid-list';


@NgModule({
  declarations: [
    ExerciseDetailsComponent, 
    ExerciseListComponent,

  ],
  imports: [
    CommonModule,
    MatGridListModule,
  ],
  exports: [
    ExerciseDetailsComponent, 
    ExerciseListComponent
  ]
})
export class ExerciseModule { }
