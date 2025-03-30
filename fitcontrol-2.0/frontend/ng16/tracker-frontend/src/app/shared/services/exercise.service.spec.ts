import { TestBed } from '@angular/core/testing';
import { HttpClientModule  } from '@angular/common/http'; 
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { ExerciseService } from './exercise.service';
import { Exercise } from 'src/app/core/model/exercise';

describe('ExerciseService', () => {
  let service: ExerciseService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
        providers: [ExerciseService], 
    });
    service = TestBed.inject(ExerciseService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify(); // Ensure that there are no outstanding requests
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });


  it('should fetch all exercises', () => {

    const dummyExercises: Exercise[] = [
        { 
            id: 1,
            title: 'Testexercise1',
            description: 'test1',
            primaryMuscleGroups: [],
            secondaryMuscleGroups: [],
            isEditing: false
         },
        { id: 2, 
            title: 'Testexercise2',
            description: 'test2',
            primaryMuscleGroups: [],
            secondaryMuscleGroups: [],
            isEditing: false
         },
      ];
  
      service.getExercises().subscribe(exercises => {
        expect(exercises.length).toBe(2);
        expect(exercises).toEqual(dummyExercises);
      });

      
      const req = httpMock.expectOne('http://host.docker.internal:8083/fitcontrol/tracker/exercise/all');
      expect(req.request.method).toBe('GET');
      req.flush(dummyExercises); 
  });

  it('should fetch one specific exercise', () => {
      const dummyExercise = { 
        id: '1',
        title: 'Testexercise1',
        description: 'test1',
        primaryMuscleGroups: [],
        secondaryMuscleGroups: [],
        isEditing: false
     }
  
      service.getExercise(dummyExercise.id).subscribe(exercise => {
        expect(exercise.title).toBe('Testexercise1');

      });
  
      const req = httpMock.expectOne('http://host.docker.internal:8083/fitcontrol/tracker/exercise/singleexercise?exerciseId=1');
      expect(req.request.method).toBe('GET');
      req.flush(dummyExercise); 
  });

  it('should create one  exercise', () => {
    let numberOfExercises = 0;

    const dummyExercises: Exercise[] = [
        { 
            id: 1,
            title: 'Testexercise1',
            description: 'test1',
            primaryMuscleGroups: [],
            secondaryMuscleGroups: [],
            isEditing: false
         },
        { id: 2, 
            title: 'Testexercise2',
            description: 'test2',
            primaryMuscleGroups: [],
            secondaryMuscleGroups: [],
            isEditing: false
         },
      ];

    service.getExercises().subscribe(exercises => {
        expect(exercises.length).toBe(2);
        expect(exercises).toEqual(dummyExercises);
      });

      const initialGetReq = httpMock.expectOne('http://host.docker.internal:8083/fitcontrol/tracker/exercise/all');
      expect(initialGetReq.request.method).toBe('GET');
      initialGetReq.flush(dummyExercises); 

    const dummyNewExercise: Exercise = { 
      id: 3,
      title: 'Testexercise3',
      description: 'test3',
      primaryMuscleGroups: [],
      secondaryMuscleGroups: [],
      isEditing: false
   }

    service.saveExercise(dummyNewExercise).subscribe(() => {
        service.getExercises().subscribe(exercises => {
            expect(exercises.length).toBe(3);
            expect(exercises[2].id).toEqual(3);
          });
        
        const getReq = httpMock.expectOne('http://host.docker.internal:8083/fitcontrol/tracker/exercise/all');
        expect(getReq.request.method).toBe('GET');
        getReq.flush([...dummyExercises, dummyNewExercise]);
      });

    const postReq = httpMock.expectOne('http://host.docker.internal:8083/fitcontrol/tracker/exercise/create');
    expect(postReq.request.method).toBe('POST');
    postReq.flush(dummyNewExercise); 

});

it('should delete one exercise', () => {

});



});