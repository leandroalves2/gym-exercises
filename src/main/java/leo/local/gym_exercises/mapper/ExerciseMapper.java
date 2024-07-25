package leo.local.gym_exercises.mapper;

import leo.local.gym_exercises.domain.entities.Exercise;
import leo.local.gym_exercises.domain.model.ExerciseDTO;
import org.springframework.stereotype.Component;

@Component
public class ExerciseMapper {

    public void dtoToEntity(ExerciseDTO exerciseDTO, Exercise exercise) {
        exercise.setName(exerciseDTO.getName());
        exercise.setDescription(exerciseDTO.getDescription());
        exercise.setMuscleGroup(exerciseDTO.getMuscleGroup());
        exercise.setRepetitions(exerciseDTO.getRepetitions());
        exercise.setWeight(exerciseDTO.getWeight());
    }

    public ExerciseDTO entityToDto(Exercise exercise, ExerciseDTO exerciseDTO){
        exerciseDTO.setId(exercise.getId());
        exerciseDTO.setName(exercise.getName());
        exerciseDTO.setDescription(exercise.getDescription());
        exerciseDTO.setMuscleGroup(exercise.getMuscleGroup());
        exerciseDTO.setRepetitions(exercise.getRepetitions());
        exerciseDTO.setWeight(exercise.getWeight());
        return exerciseDTO;
    }

}
