package leo.local.gym_exercises.controller.exercicios;

import leo.local.gym_exercises.domain.entities.ExerciciosEntity;
import leo.local.gym_exercises.mapper.ExercicioMapper;
import leo.local.gym_exercises.domain.model.ExerciciosDTO;
import leo.local.gym_exercises.services.ExerciciosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/exercicio")
public class ListarExerciciosController {

    private final ExerciciosService exercisesService;

    @GetMapping("/listar")
    public ResponseEntity<List<ExerciciosDTO>> ListarExercicio() {
        try {
            List<ExerciciosEntity> entityList = exercisesService.listarExercicios();
            List<ExerciciosDTO> dtoList = new ArrayList<>();
            for(ExerciciosEntity entity : entityList){
                dtoList.add(ExercicioMapper.setEntityToDto(entity));
            }
            return ResponseEntity.ok(dtoList);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(),
                    String.format("Não foi possivel Listar os exercícios."));
        }
    }


}
