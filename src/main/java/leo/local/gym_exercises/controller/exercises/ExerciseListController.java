package leo.local.gym_exercises.controller.exercises;

import leo.local.gym_exercises.domain.entities.Exercise;
import leo.local.gym_exercises.domain.model.ExerciseDTO;
import leo.local.gym_exercises.mapper.ExerciseMapper;
import leo.local.gym_exercises.services.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/exercise")
public class ExerciseListController {

    private final ExerciseService exercisesService;
    @Autowired
    private final ExerciseMapper exerciseMapper;

    @GetMapping("/list")
    public ResponseEntity<List<ExerciseDTO>> ListarExercicio() {
        try {
            List<Exercise> entityList = exercisesService.exerciseList();
            List<ExerciseDTO> dtoList = new ArrayList<>();
            for(Exercise entity : entityList){
                ExerciseDTO dto = new ExerciseDTO();
                dtoList.add(exerciseMapper.entityToDto(entity, dto));
            }
            return ResponseEntity.ok(dtoList);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(),
                    String.format("Não foi possivel Listar os exercícios."));
        }
    }


}
