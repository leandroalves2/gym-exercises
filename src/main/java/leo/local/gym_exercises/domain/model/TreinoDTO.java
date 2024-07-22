package leo.local.gym_exercises.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TreinoDTO {

    private String nome;
    private List<ExerciciosDTO> exerciciosDTOList;

}
