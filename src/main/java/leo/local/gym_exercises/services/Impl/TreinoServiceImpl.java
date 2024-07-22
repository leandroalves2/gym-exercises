package leo.local.gym_exercises.services.Impl;

import jakarta.transaction.Transactional;
import leo.local.gym_exercises.domain.entities.ExerciciosEntity;
import leo.local.gym_exercises.domain.entities.TreinoEntity;
import leo.local.gym_exercises.domain.model.ExerciciosDTO;
import leo.local.gym_exercises.domain.model.TreinoDTO;
import leo.local.gym_exercises.exception.BusinessException;
import leo.local.gym_exercises.repository.TreinoRepository;
import leo.local.gym_exercises.services.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TreinoServiceImpl implements TreinoService {

    @Autowired
    private TreinoRepository treinoRepository;

    @Autowired
    private ExerciciosServiceImpl exerciciosService;



    @Transactional
    public void cadastrarTreino(TreinoDTO treinoDTO){
        try {
            List<ExerciciosEntity> exerciciosEntityList = new ArrayList<>();

            for (ExerciciosDTO exerciciosDTO : treinoDTO.getExerciciosDTOList()){
                exerciciosService.persistirExercicio(exerciciosDTO);
                exerciciosEntityList.add(exerciciosService.buscarPorNomeExercicios(exerciciosDTO.getNome()));
            }

            TreinoEntity treinoEntity = new TreinoEntity();
            treinoEntity.setNome(treinoDTO.getNome());
            treinoEntity.setExerciciosEntityList(exerciciosEntityList);


        }catch (BusinessException e){
            throw new BusinessException("Não foi possivel cadastrar o treino");
        }
    }
}
