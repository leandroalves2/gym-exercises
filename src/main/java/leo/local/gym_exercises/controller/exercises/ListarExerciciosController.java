package leo.local.gym_exercises.controller.exercises;

import leo.local.gym_exercises.exception.BusinessException;
import leo.local.gym_exercises.model.ExerciciosDTO;
import leo.local.gym_exercises.services.ExerciciosService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/exercicio")
public class ListarExerciciosController {

    private final ExerciciosService exercisesService;

    @GetMapping("/listar")
    public Page<ExerciciosDTO> ListarExercicios(Pageable pageable) {
        try {
            return exercisesService.ListarExercicios(pageable);
        }catch (BusinessException e){
            throw new BusinessException("Não foi possivel listar os exercicios");
        }
    }

}
