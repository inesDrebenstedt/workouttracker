import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from './../../../../src/environments/environment.local';
import { Workout } from 'src/app/core/model/workout';

@Injectable({
  providedIn: 'root'
})
export class WorkoutService {

  private apiUrl = `${environment.apiBaseUrl}/workout`;

  constructor(private http: HttpClient) { }

  getWorkouts(): Observable<Workout[]> {
    return this.http.get<Workout[]>(`${this.apiUrl}/all`);
  }

  getWorkout(id: string): Observable<Workout> {
    return this.http.get<Workout>(`${this.apiUrl}/${id}`);
  }

}
