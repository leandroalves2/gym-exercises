package leo.local.gym_exercises.services.Impl;

import leo.local.gym_exercises.domain.entities.Exercise;
import leo.local.gym_exercises.domain.entities.Workout;
import leo.local.gym_exercises.domain.model.WorkoutDTO;
import leo.local.gym_exercises.exception.BusinessException;
import leo.local.gym_exercises.repository.ExerciseRepository;
import leo.local.gym_exercises.repository.WorkoutRepository;
import leo.local.gym_exercises.services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkoutServiceImpl implements WorkoutService {

    @Autowired
    WorkoutRepository workoutRepository;
    @Autowired
    ExerciseRepository exerciseRepository;
    public void createWorkout(WorkoutDTO dto){
        Workout workout = new Workout();
        workout.setName(dto.getName());
        List<Exercise> exerciseList = new ArrayList<>();
        for(Exercise exercise : dto.getExerciseList()){
            Optional<Exercise> optionalExercise = exerciseRepository.findByName(exercise.getName());
            if(optionalExercise.isPresent()){
                exerciseList.add(exercise);
            }else {
                throw new BusinessException("Exercício não encontrado, erro para criar o treino");
            }
        }

        workoutRepository.save(workout);
    }
}
