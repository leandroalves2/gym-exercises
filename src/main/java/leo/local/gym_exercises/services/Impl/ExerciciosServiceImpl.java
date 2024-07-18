package leo.local.gym_exercises.services.Impl;

import leo.local.gym_exercises.domain.entities.ExerciciosEntity;
import leo.local.gym_exercises.exception.BusinessException;
import leo.local.gym_exercises.mapper.ExercicioMapper;
import leo.local.gym_exercises.domain.model.ExerciciosDTO;
import leo.local.gym_exercises.repository.ExerciciosRepository;
import leo.local.gym_exercises.services.ExerciciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciciosServiceImpl implements ExerciciosService {

    @Autowired
    private ExerciciosRepository exerciciosRepository;
    private ExercicioMapper exercicioMapper;

    public void persistirExercicio(ExerciciosDTO exerciciosDTO){
            if (exerciciosDTO.getId() == null) {
                CadastrarExercicio(exerciciosDTO);
            } else {
                EditarExercicio(exerciciosDTO);
            }
    }

    public void CadastrarExercicio(ExerciciosDTO exerciciosDTO){
        try {
            ExerciciosEntity entity = new ExerciciosEntity();
            setDtoToEntity(entity, exerciciosDTO);
            exerciciosRepository.save(entity);
        }catch (BusinessException e){
            throw new BusinessException("Não foi possivel cadastrar o exercicio");
        }
    }

    public void EditarExercicio(ExerciciosDTO exerciciosDTO){
        try {

            ExerciciosEntity entity = buscarPorIdExercicios(exerciciosDTO.getId());
            setDtoToEntity(entity, exerciciosDTO);
            exerciciosRepository.save(entity);
        }catch (BusinessException e){
            throw new BusinessException("Não foi possivel editar o exercicio");
        }
    }

    public void DeletarExercicio(Long id) {
        try {
            ExerciciosEntity entity = buscarPorIdExercicios(id);
            exerciciosRepository.delete(entity);
        }catch (BusinessException e){
            throw new BusinessException("Não foi possivel editar o exercicio");
        }
    }

    public List<ExerciciosEntity> listarExercicios(){
        List<ExerciciosEntity> entity = exerciciosRepository.findAll();
        if (entity == null || entity.isEmpty()) {
            throw new BusinessException(String.format("Não foi possível listar os exercícios."));
        }else{
            return entity;
        }
    }

    public ExerciciosEntity buscarPorIdExercicios(Long id) {
        if (id == null) {
            throw new BusinessException("ID não pode ser nulo.");
        }
        return exerciciosRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Exercício não encontrado com o ID: " + id));
    }

    public ExerciciosEntity buscarPorNomeExercicios(String nome){
        if (nome == null || nome.trim().isEmpty()) {
            throw new BusinessException("O nome não pode ser nulo ou vazio.");
        }

        ExerciciosEntity exercicio = exerciciosRepository.findByNome(nome);
        if (exercicio == null) {
            throw new BusinessException("Exercício não encontrado com o nome: " + nome);
        }

        return exercicio;
    }

    public ExerciciosEntity setDtoToEntity(ExerciciosEntity entity, ExerciciosDTO exercisesDTO){

        entity.setNome(exercisesDTO.getNome());
        entity.setDescricao(exercisesDTO.getDescricao());
        entity.setGrupoMuscular(exercisesDTO.getGrupoMuscular());
        entity.setEquipamento(exercisesDTO.getEquipamento());
        entity.setRepeticoes(exercisesDTO.getRepeticoes());
        entity.setPeso(exercisesDTO.getPeso());
        return entity;
    }


}
