import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ExerciseDetailsComponent } from './pages/details/exercise-details.component';
import { ExerciseListComponent } from './pages/list/exercise-list.component';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatToolbarModule } from '@angular/material/toolbar';
import { SharedModule } from 'src/app/shared/shared.module';


@NgModule({
  declarations: [
    ExerciseDetailsComponent, 
    ExerciseListComponent,

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
    ExerciseDetailsComponent, 
    ExerciseListComponent
  ]
})
export class ExerciseModule { }
