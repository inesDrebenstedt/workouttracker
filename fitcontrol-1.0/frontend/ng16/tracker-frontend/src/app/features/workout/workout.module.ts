import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { WorkoutDetailComponent } from './pages/workout-detail/workout-detail.component';
import { WorkoutListComponent } from './pages/workout-list/workout-list.component';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatToolbarModule } from '@angular/material/toolbar';
import { SharedModule } from 'src/app/shared/shared.module';


@NgModule({
  declarations: [
    WorkoutDetailComponent, 
    WorkoutListComponent,

  ],
  imports: [
    CommonModule,
    SharedModule,
    MatGridListModule,
    MatButtonModule,
    MatIconModule,
    MatExpansionModule,
    MatToolbarModule
  ],
  exports: [
    WorkoutDetailComponent, 
    WorkoutListComponent
  ]
})
export class WorkoutModule { }
