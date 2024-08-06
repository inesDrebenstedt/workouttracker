import { ExerciseSet } from "./exercise-set";

export interface Exercise {
    id?: string;
    title: string;
    description: string;
    primaryMuscleGroups: string[];
    secondaryMuscleGroups: string[];
    sets: ExerciseSet[];
  }
