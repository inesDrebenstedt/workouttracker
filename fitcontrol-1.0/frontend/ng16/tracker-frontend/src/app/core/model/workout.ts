import { Exercise } from "./exercise";

export interface Workout {
    id?: string;
	  exercises: Exercise[];
	  title: string;
    date: Date;
    durationInSeconds?: number; // Duration in minutes
  }