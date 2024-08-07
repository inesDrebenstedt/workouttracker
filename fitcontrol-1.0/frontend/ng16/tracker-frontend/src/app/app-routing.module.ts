// src/app/app-routing.module.ts
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './features/home/component/home.component'; 
import { WorkoutListComponent } from './features/workout/pages/workout-list/workout-list.component';
import { WorkoutCreateComponent } from './features/workout/pages/workout-create/workout-create.component';
import { WorkoutDetailComponent } from './features/workout/pages/workout-detail/workout-detail.component';
import { ExerciseListComponent } from './features/exercise/pages/list/exercise-list.component';
import { ExerciseDetailsComponent } from './features/exercise/pages/details/exercise-details.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'workout/all', component: WorkoutListComponent },
  { path: 'workout/singleworkout', component: WorkoutDetailComponent },
  { path: 'exercise/all', component: ExerciseListComponent },
  { path: 'exercise/singleexercise', component: ExerciseDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
