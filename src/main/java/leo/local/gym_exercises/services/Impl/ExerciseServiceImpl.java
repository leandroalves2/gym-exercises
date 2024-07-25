package leo.local.gym_exercises.services.Impl;

import leo.local.gym_exercises.domain.entities.Exercise;
import leo.local.gym_exercises.exception.BusinessException;
import leo.local.gym_exercises.domain.model.ExerciseDTO;
import leo.local.gym_exercises.mapper.ExerciseMapper;
import leo.local.gym_exercises.repository.ExerciseRepository;
import leo.local.gym_exercises.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private ExerciseMapper exercicioMapper;

    public void saveOrUpdateExercise(ExerciseDTO dto) {
        try {
            if (dto.getId() == null) {
                Exercise entity = new Exercise();
                exercicioMapper.dtoToEntity(dto, entity);
                exerciseRepository.save(entity);
            } else {
                Exercise entity = findExerciseById(dto.getId());
                if (entity != null) {
                    exercicioMapper.dtoToEntity(dto, entity);
                    exerciseRepository.save(entity);
                }else {
                    throw new BusinessException("Exercício com o ID " + dto.getId() + " não encontrado.");
                }
            }
        } catch (Exception e) {
            throw new BusinessException("Não foi possível salvar ou atualizar o exercício. Erro: " + e.getMessage());
        }
    }


    public void deleteExercise(Long id) {
        try {
            Exercise entity = findExerciseById(id);
            if (entity != null) {
                exerciseRepository.delete(entity);
            } else {
                throw new BusinessException("Exercício com o ID " + id + " não encontrado.");
            }
        } catch (Exception e) {
            throw new BusinessException("Não foi possível excluir o exercício. Erro: " + e.getMessage(), e);
        }
    }

    public List<Exercise> exerciseList() {
        List<Exercise> exercises = exerciseRepository.findAll();
        if (exercises.isEmpty()) {
            throw new BusinessException("Nenhum exercício encontrado na lista.");
        }
        return exercises;
    }

    public Exercise findExerciseById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID não pode ser nulo.");
        }
        try {
            Optional<Exercise> exerciseOptional = exerciseRepository.findById(id);
            if (exerciseOptional.isPresent()) {
                Exercise exercise = exerciseOptional.get();
                return exercise;
            } else {
                throw new BusinessException("Exercício não encontrado com o ID: " + id);
            }
        } catch (Exception e) {
            throw new BusinessException("Erro ao buscar exercício com o ID: " + id, e);
        }
    }

    public Exercise findExerciseByName(String name) {
        if(name == null){
            throw new IllegalArgumentException("O nome não pode ser nulo.");
        }
        try{
            Optional<Exercise> exerciseOptional = exerciseRepository.findByName(name);
            if(exerciseOptional.isPresent()){
                Exercise exercise = exerciseOptional.get();
                return exercise;
            }
            else{
                throw new BusinessException("Exercício não encontrado com o nome: " + name);
            }
        } catch (Exception e) {
            throw new BusinessException("Erro ao buscar exercício com o nome: " + name, e);
        }

    }


}
