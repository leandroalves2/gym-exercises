package leo.local.gym_exercises.controller.exercises;

import leo.local.gym_exercises.entities.ExercisesEntity;
import leo.local.gym_exercises.exception.BusinessException;
import leo.local.gym_exercises.model.ExercisesDTO;
import leo.local.gym_exercises.services.ExercisesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("/exercicio")
public class CadastrarExercicioController {

    private final ExercisesService exercisesService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> CadastrarExercicio(@RequestBody ExercisesDTO exercisesDTO) {
        try {
            exercisesService.CadastrarExercicio(exercisesDTO);
            return ResponseEntity.ok("Exericio Cadastrado com sucesso!");
        }catch (BusinessException e){
            throw new BusinessException("Não foi possivel cadastrar o exercicio");
        }
    }


}
