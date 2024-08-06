import { Component, Input } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {
  //@Input('navbarTitle') 
  navbarTitle: string = 'default navbar title';

  currentUrl: string = '';

  constructor(private router: Router) {}

  ngOnInit() {
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        console.log('Current URL:', event.urlAfterRedirects);
        this.currentUrl = event.urlAfterRedirects;
        this.navbarTitle = this.updateTitleBar();
      }
    });
  }


  updateTitleBar(): string {
    switch(this.currentUrl) {
      case '/workout/all':
        console.log('CASE 1 ' + this.currentUrl);
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
