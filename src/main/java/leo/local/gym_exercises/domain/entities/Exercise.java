package leo.local.gym_exercises.domain.entities;

import jakarta.persistence.*;
import leo.local.gym_exercises.domain.enums.MuscleGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "exercise_tb")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String description;
    @Enumerated
    private MuscleGroup muscleGroup;
    private String equipment;
    private int repetitions;
    private double weight;

}
