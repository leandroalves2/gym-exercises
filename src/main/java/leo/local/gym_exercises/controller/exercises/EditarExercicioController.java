package leo.local.gym_exercises.controller.exercises;

import leo.local.gym_exercises.exception.BusinessException;
import leo.local.gym_exercises.model.ExerciciosDTO;
import leo.local.gym_exercises.services.ExerciciosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/exercicio")
public class EditarExercicioController {

    private final ExerciciosService exercisesService;

    @PostMapping("/editar")
    public ResponseEntity<String> EditarExercicio(@RequestBody ExerciciosDTO exercisesDTO) {
        try {
            exercisesService.editarExercicio(exercisesDTO);
            return ResponseEntity.ok("Exericio editado com sucesso!");
        }catch (BusinessException e){
            throw new BusinessException("Não foi possivel editado o exercicio");
        }
    }
}