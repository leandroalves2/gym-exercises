package leo.local.gym_exercises.controller.exercises;

import leo.local.gym_exercises.exception.BusinessException;
import leo.local.gym_exercises.model.ExerciciosDTO;
import leo.local.gym_exercises.services.ExerciciosService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/exercicio")
public class ConsultarExerciciosIdController {

    private final ExerciciosService exercisesService;

    @GetMapping("/id/{id}")
    public ExerciciosDTO buscarPorIdExercicios(@PathVariable Long id) {
        try {
            return exercisesService.buscarPorId(id);
        } catch (BusinessException e) {
            throw new BusinessException("Não foi possivel encontrar o exercicios");
        }
    }


}
