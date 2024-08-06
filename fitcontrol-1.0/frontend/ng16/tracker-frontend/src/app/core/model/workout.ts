import { Exercise } from "./exercise";

export interface Workout {
    id?: string;
	  exercises: Exercise[];
	  title: string;
    date: Date;
    duration?: number; // Duration in minutes
  }