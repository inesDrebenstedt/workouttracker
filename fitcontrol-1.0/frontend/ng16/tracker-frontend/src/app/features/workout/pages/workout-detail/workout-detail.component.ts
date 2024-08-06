import { Component, OnInit } from '@angular/core';
import { WorkoutService } from 'src/app/shared/services/workout.service';
import { ActivatedRoute } from '@angular/router';
import { Workout } from 'src/app/core/model/workout';

@Component({
  selector: 'app-workout-detail',
  templateUrl: './workout-detail.component.html',
  styleUrls: ['./workout-detail.component.scss']
})
export class WorkoutDetailComponent implements OnInit {

 workout: Workout | undefined;

  constructor(private workoutService: WorkoutService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.workoutService.getWorkout(id).subscribe(data => {
        this.workout = data;
      });
    }
  }

}
