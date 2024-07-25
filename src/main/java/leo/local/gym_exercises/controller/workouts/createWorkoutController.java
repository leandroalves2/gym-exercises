package leo.local.gym_exercises.controller.workouts;

import leo.local.gym_exercises.domain.model.WorkoutDTO;
import leo.local.gym_exercises.services.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/workout")
public class createWorkoutController {

    @Autowired
   private final WorkoutService workoutService;

    @PostMapping
    public ResponseEntity<String> createWorkout(@RequestBody WorkoutDTO dto){
        try{
            workoutService.createWorkout(dto);
            return ResponseEntity.ok("Treino Cadastrado com sucesso!");
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(),
                    String.format("Não foi possivel cadastrar o treino."));
        }
    }

}
