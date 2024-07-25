package leo.local.gym_exercises.domain.model;

import leo.local.gym_exercises.domain.entities.Exercise;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkoutDTO     {

    private String name;
    private List<Exercise> exerciseList;


}
