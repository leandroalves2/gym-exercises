package leo.local.gym_exercises.services;

import leo.local.gym_exercises.domain.entities.Exercise;
import leo.local.gym_exercises.domain.model.ExerciseDTO;

import java.util.List;
import java.util.Optional;

public interface ExerciseService {

    void saveOrUpdateExercise(ExerciseDTO dto);
    void deleteExercise(Long id);

    List<Exercise> exerciseList();

    Exercise findExerciseById(Long id);

    Exercise findExerciseByName(String nome);

    }
