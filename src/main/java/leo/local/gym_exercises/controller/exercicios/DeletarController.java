package leo.local.gym_exercises.controller.exercicios;

import leo.local.gym_exercises.services.ExerciciosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/exercicio")
public class DeletarController {

    private final ExerciciosService exercisesService;


    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> PersistirExercicio(@PathVariable Long id)  {
        try {
            exercisesService.DeletarExercicio(id);
            return ResponseEntity.ok("Exericio deletado com sucesso!");

        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(),
                    String.format("Não foi possivel deletar o exercício."));
        }
    }

}
