import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module'; 
import { AppComponent } from './app.component';
import { HomeModule } from './features/home/home.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './shared/material/material/material.module';
import { SharedModule } from './shared/shared.module';
import { WorkoutModule } from './features/workout/workout.module';
import { HttpClientModule } from '@angular/common/http';
import { WorkoutService } from './shared/services/workout.service';
import { ExerciseModule } from './features/exercise/exercise.module';
import { ExerciseService } from './shared/services/exercise.service';

@NgModule({
  declarations: [AppComponent, 
    
  ],
  imports: [
    BrowserModule, 
    HttpClientModule,
    AppRoutingModule, 
    HomeModule, 
    WorkoutModule,
    ExerciseModule,
    SharedModule,
    BrowserAnimationsModule,
    MaterialModule,
  ], 
  providers: [
    WorkoutService, 
    ExerciseService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
