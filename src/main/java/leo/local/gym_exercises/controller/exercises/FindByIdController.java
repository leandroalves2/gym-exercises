package leo.local.gym_exercises.controller.exercises;

import leo.local.gym_exercises.domain.entities.Exercise;
import leo.local.gym_exercises.domain.model.ExerciseDTO;
import leo.local.gym_exercises.mapper.ExerciseMapper;
import leo.local.gym_exercises.services.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;


@RequiredArgsConstructor
@RestController
@RequestMapping("/exercise")
public class FindByIdController {

    private final ExerciseService exercisesService;
    private final ExerciseMapper exerciseMapper;

    @GetMapping("/id/{id}")
    public ResponseEntity<ExerciseDTO> BuscarPorId(@PathVariable Long id) {
        try {
            Exercise entity = exercisesService.findExerciseById(id);
            ExerciseDTO dto = new ExerciseDTO();
            dto = exerciseMapper.entityToDto(entity, dto);
            return ResponseEntity.ok(dto);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(),
                    String.format("Não foi possivel encontrar o exercício."));
        }
    }

}
