package leo.local.gym_exercises.model;

import leo.local.gym_exercises.enums.GrupoMuscular;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExerciciosDTO {

    private Long id;
    private String nome;
    private String descricao;
    private GrupoMuscular grupoMuscular;
    private String equipamento;

}
