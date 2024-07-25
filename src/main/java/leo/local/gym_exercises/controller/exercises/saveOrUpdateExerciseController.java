package leo.local.gym_exercises.controller.exercises;

import leo.local.gym_exercises.domain.model.ExerciseDTO;
import leo.local.gym_exercises.services.ExerciseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.HttpClientErrorException;


@RequiredArgsConstructor
@RestController
@RequestMapping("/exercise")
public class saveOrUpdateExerciseController {

    private final ExerciseService exerciseService;

    @PostMapping()
    public ResponseEntity<String> persistExercise(@RequestBody ExerciseDTO exercisesDTO) {
        try {
            exerciseService.saveOrUpdateExercise(exercisesDTO);
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
