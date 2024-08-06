import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { WorkoutDetailComponent } from './pages/workout-detail/workout-detail.component';
import { WorkoutListComponent } from './pages/workout-list/workout-list.component';
import { MatGridListModule } from '@angular/material/grid-list';


@NgModule({
  declarations: [
    WorkoutDetailComponent, 
    WorkoutListComponent,

  ],
  imports: [
    CommonModule,
    MatGridListModule,
  ],
  exports: [
    WorkoutDetailComponent, 
    WorkoutListComponent
  ]
})
export class WorkoutModule { }
