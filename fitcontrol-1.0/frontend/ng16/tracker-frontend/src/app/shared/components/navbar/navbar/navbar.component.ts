import { Component, Input } from '@angular/core';
import { Router, NavigationEnd, ActivatedRoute } from '@angular/router';
import { WorkoutService } from 'src/app/shared/services/workout.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {
  //@Input('navbarTitle') 
  navbarTitle: string = ' ';

  currentUrl: string = '';

  constructor(
    private router: Router, 
    private route: ActivatedRoute, 
    private workoutService: WorkoutService,
  ) {}

  ngOnInit() {
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        console.log('Current URL:', event.urlAfterRedirects);
        this.currentUrl = event.urlAfterRedirects;
        this.navbarTitle = this.updateTitleBar();
      }
    });
  }


  getWorkoutTitle(): string {
    this.route.queryParams.subscribe(params => {
      const id = params['workoutId'];
      if (id) {
        this.workoutService.getWorkout(id).subscribe(workout => {
          this.navbarTitle = workout.title;
        });
      }
    });
    return this.navbarTitle;
  }



  updateTitleBar(): string {

    if (this.currentUrl.includes('/workout/singleworkout')) {
      return this.getWorkoutTitle();
    }
    
    switch(this.currentUrl) {
      case '/':
        return 'Home Page of Workout Tracker';

      case '/workout/all':
        console.log('updateTitleBar CASE 1 ' + this.currentUrl);
          return 'List of Workouts';

        case '/workout/create':
          return 'Create new Workout';
    }

    return this.navbarTitle
  }

  onMenuClick () {
    alert( 'menu button was clicked!');
  }

}
