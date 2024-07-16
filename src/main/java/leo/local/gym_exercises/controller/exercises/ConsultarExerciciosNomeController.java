package leo.local.gym_exercises.controller.exercises;

import leo.local.gym_exercises.exception.BusinessException;
import leo.local.gym_exercises.model.ExerciciosDTO;
import leo.local.gym_exercises.services.ExerciciosService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/exercicio")
public class ConsultarExerciciosNomeController {

    private final ExerciciosService exercisesService;

    @GetMapping("/{nome}")
    public Page<ExerciciosDTO> buscarPorNomeExercicios(@PathVariable String nome, Pageable page) {
        try {
            return exercisesService.findByNomeContaining(nome, page);
        } catch (BusinessException e) {
            throw new BusinessException("Não foi possivel encontrar o exercicios");
        }
    }


}
