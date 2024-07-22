package leo.local.gym_exercises.controller.exercicios;

import leo.local.gym_exercises.domain.model.ExerciciosDTO;
import leo.local.gym_exercises.services.ExerciciosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.HttpClientErrorException;


@RequiredArgsConstructor
@RestController
@RequestMapping("/exercicio")
public class PersistirExercicioController {

    private final ExerciciosService exerciciosService;

    @PostMapping()
    public ResponseEntity<String> PersistirExercicio(@RequestBody ExerciciosDTO exercisesDTO) {
        try {
            exerciciosService.persistirExercicio(exercisesDTO);
            if(exercisesDTO.getId() == null){
                return ResponseEntity.ok("Exericio Cadastrado com sucesso!");
            }
            else{
                return ResponseEntity.ok("Exericio Editado com sucesso!");
            }
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(),
                    String.format("Não foi possivel cadastrar o exercício."));
        }
    }


}
