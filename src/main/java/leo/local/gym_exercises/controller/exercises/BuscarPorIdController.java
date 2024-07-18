package leo.local.gym_exercises.controller.exercises;

import leo.local.gym_exercises.domain.entities.ExerciciosEntity;
import leo.local.gym_exercises.mapper.ExercicioMapper;
import leo.local.gym_exercises.domain.model.ExerciciosDTO;
import leo.local.gym_exercises.services.ExerciciosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;


@RequiredArgsConstructor
@RestController
@RequestMapping("/exercicio")
public class BuscarPorIdController {

    private final ExerciciosService exercisesService;

    @GetMapping("/id/{id}")
    public ResponseEntity<ExerciciosDTO> BuscarPorId(@PathVariable Long id) {
        try {
            ExerciciosEntity entity = exercisesService.buscarPorIdExercicios(id);
            ExerciciosDTO dto = ExercicioMapper.exerciciostoDTO(entity);
            return ResponseEntity.ok(dto);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(),
                    String.format("Não foi possivel encontrar o exercício."));
        }
    }

}
