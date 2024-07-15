package leo.local.gym_exercises.controller.exercises;

import leo.local.gym_exercises.exception.BusinessException;
import leo.local.gym_exercises.model.ExerciciosDTO;
import leo.local.gym_exercises.services.ExerciciosService;
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

    private final ExerciciosService exercisesService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> CadastrarExercicio(@RequestBody ExerciciosDTO exercisesDTO) {
        try {
            exercisesService.CadastrarExercicio(exercisesDTO);
            return ResponseEntity.ok("Exericio Cadastrado com sucesso!");
        }catch (BusinessException e){
            throw new BusinessException("Não foi possivel cadastrar o exercicio");
        }
    }


}
