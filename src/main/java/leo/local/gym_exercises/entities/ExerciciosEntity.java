package leo.local.gym_exercises.entities;

import jakarta.persistence.*;
import leo.local.gym_exercises.enums.GrupoMuscular;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "exercicios_tb")
public class ExerciciosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String descricao;
    @Enumerated
    private GrupoMuscular grupoMuscular;
    private String equipamento;

}
