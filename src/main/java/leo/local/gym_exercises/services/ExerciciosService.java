package leo.local.gym_exercises.services;

import leo.local.gym_exercises.domain.entities.ExerciciosEntity;
import leo.local.gym_exercises.domain.model.ExerciciosDTO;

import java.util.List;

public interface ExerciciosService {

    void persistirExercicio(ExerciciosDTO exerciciosDTO);
    void CadastrarExercicio(ExerciciosDTO exercisesDTO);
    void EditarExercicio(ExerciciosDTO exercisesDTO);
    void DeletarExercicio(Long id);

    List<ExerciciosEntity> listarExercicios();

    ExerciciosEntity buscarPorIdExercicios(Long id);

    ExerciciosEntity buscarPorNomeExercicios(String nome);

    }
