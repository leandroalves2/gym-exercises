package leo.local.gym_exercises.services;

import leo.local.gym_exercises.model.ExerciciosDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ExerciciosService {

    void CadastrarExercicio(ExerciciosDTO exercisesDTO);

    Page<ExerciciosDTO> ListarExercicios(Pageable pageable);

    Page<ExerciciosDTO> findByNomeContaining(String nome, Pageable pageable);


}
