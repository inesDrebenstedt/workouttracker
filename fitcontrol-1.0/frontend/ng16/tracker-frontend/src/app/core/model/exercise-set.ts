import { Rep } from "./rep";

export interface ExerciseSet {
    id?: string;
    weight: number;
    unit: string;
    reps: Rep[];
    description: string;
    numberOfReps: number;
    exerciseId: string;
  }