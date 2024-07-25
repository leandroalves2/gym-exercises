package leo.local.gym_exercises.controller.exercises;

import leo.local.gym_exercises.services.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/exercise")
public class DeleteExercise {

    private final ExerciseService exercisesService;


    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> PersistirExercicio(@PathVariable Long id)  {
        try {
            exercisesService.deleteExercise(id);
            return ResponseEntity.ok("Exericio deletado com sucesso!");

        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(),
                    String.format("Não foi possivel deletar o exercício."));
        }
    }

}
