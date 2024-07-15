package leo.local.gym_exercises.services.Impl;

import leo.local.gym_exercises.entities.ExerciciosEntity;
import leo.local.gym_exercises.model.ExerciciosDTO;
import leo.local.gym_exercises.repository.ExerciciosRepository;
import leo.local.gym_exercises.services.ExerciciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciciosServiceImpl implements ExerciciosService {

    @Autowired
    private ExerciciosRepository exercisesRepository;

    public void CadastrarExercicio(ExerciciosDTO exercisesDTO){
        ExerciciosEntity exercisesEntity = new ExerciciosEntity();

        exercisesEntity.setNome(exercisesDTO.getNome());
        exercisesEntity.setDescricao(exercisesDTO.getDescricao());
        exercisesEntity.setGrupoMuscular(exercisesDTO.getGrupoMuscular());
        exercisesEntity.setEquipamento(exercisesDTO.getEquipamento());

         exercisesRepository.save(exercisesEntity);
    }

}
