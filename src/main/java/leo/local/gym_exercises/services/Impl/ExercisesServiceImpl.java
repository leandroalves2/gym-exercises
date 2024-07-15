package leo.local.gym_exercises.services.Impl;

import leo.local.gym_exercises.entities.ExercisesEntity;
import leo.local.gym_exercises.model.ExercisesDTO;
import leo.local.gym_exercises.repository.ExercisesRepository;
import leo.local.gym_exercises.services.ExercisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExercisesServiceImpl implements ExercisesService {

    @Autowired
    private ExercisesRepository exercisesRepository;

    public void CadastrarExercicio(ExercisesDTO exercisesDTO){
        ExercisesEntity exercisesEntity = new ExercisesEntity();

        exercisesEntity.setNome(exercisesDTO.getNome());
        exercisesEntity.setDescricao(exercisesDTO.getDescricao());
        exercisesEntity.setGrupoMuscular(exercisesDTO.getGrupoMuscular());
        exercisesEntity.setEquipamento(exercisesDTO.getEquipamento());

         exercisesRepository.save(exercisesEntity);
    }


}
