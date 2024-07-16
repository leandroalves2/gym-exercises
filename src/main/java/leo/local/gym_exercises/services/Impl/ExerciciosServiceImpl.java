package leo.local.gym_exercises.services.Impl;

import leo.local.gym_exercises.entities.ExerciciosEntity;
import leo.local.gym_exercises.exception.BusinessException;
import leo.local.gym_exercises.mapper.ExercicioMapper;
import leo.local.gym_exercises.model.ExerciciosDTO;
import leo.local.gym_exercises.repository.ExerciciosRepository;
import leo.local.gym_exercises.services.ExerciciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ExerciciosServiceImpl implements ExerciciosService {

    @Autowired
    private ExerciciosRepository exerciciosRepository;
    private ExercicioMapper exercicioMapper;

    public void CadastrarExercicio(ExerciciosDTO exercisesDTO){
        ExerciciosEntity exercisesEntity = new ExerciciosEntity();

        exercisesEntity.setNome(exercisesDTO.getNome());
        exercisesEntity.setDescricao(exercisesDTO.getDescricao());
        exercisesEntity.setGrupoMuscular(exercisesDTO.getGrupoMuscular());
        exercisesEntity.setEquipamento(exercisesDTO.getEquipamento());

        exerciciosRepository.save(exercisesEntity);
    }

    @Override
    public Page<ExerciciosDTO> ListarExercicios(Pageable pageable) {
        Page<ExerciciosEntity> page = exerciciosRepository.findAll(pageable);
        return page.map(ExercicioMapper::exerciciostoDTO);
    }

    @Override
    public ExerciciosDTO findByNomeContaining(String nome) {
        ExerciciosEntity entity = exerciciosRepository.findByNomeContaining(nome);
        return ExercicioMapper.exerciciostoDTO(entity);
    }

    public ExerciciosDTO buscarPorId(Long id) {
        ExerciciosEntity entity = exerciciosRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Exercício não encontrado"));
        return ExercicioMapper.exerciciostoDTO(entity);
    }


}
