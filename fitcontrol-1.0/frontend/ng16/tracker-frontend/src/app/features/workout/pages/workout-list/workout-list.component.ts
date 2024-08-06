import { Component, OnInit } from '@angular/core';
import { WorkoutService } from 'src/app/shared/services/workout.service';
import { ActivatedRoute } from '@angular/router';
import { Workout } from 'src/app/core/model/workout';
import { format, parseISO } from 'date-fns';
import { Router,  } from '@angular/router';

@Component({
  selector: 'app-workout-list',
  templateUrl: './workout-list.component.html',
  styleUrls: ['./workout-list.component.scss']
})
export class WorkoutListComponent implements OnInit{

  navbarTitle: string = 'List of Workouts';
  testDate = new Date();

   workout1: Workout = {
    id: '1',
	  exercises: [],
	  title: 'Test workout 1',
    date: this.testDate,
    duration: 60 // Duration in minutes
  };

  workout2: Workout = {
    id: '2',
	  exercises: [],
	  title: 'Test workout 2',
    date: this.testDate,
    duration: 60 // Duration in minutes
  };

  fakeWorkouts: Workout[] = [this.workout1, this.workout2];

  workouts: Workout[] | undefined;

  constructor(private workoutService: WorkoutService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    console.log('inside ngOnInit() of WorkoutListComponent');

    this.workoutService.getWorkouts().subscribe(data => {
      this.workouts = data;
      console.log('call to BE: ' + this.workouts.length);
    });
    

    /*
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.workoutService.getWorkouts().subscribe(data => {
        this.workouts = data;
      });
    }
      */
  }


  onTileClick(workoutId: String): void {

    this.router.navigate(['workout/singleworkout'], { queryParams: { workoutId: workoutId } });
  }

}
