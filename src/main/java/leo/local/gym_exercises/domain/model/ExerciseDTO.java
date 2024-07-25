package leo.local.gym_exercises.domain.model;

import leo.local.gym_exercises.domain.enums.MuscleGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExerciseDTO {

    private Long id;
    private String name;
    private String description;
    private MuscleGroup muscleGroup;
    private String equipment;
    private int repetitions;
    private double weight;

}
