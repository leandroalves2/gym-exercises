package leo.local.gym_exercises.mapper;

import leo.local.gym_exercises.domain.entities.ExerciciosEntity;
import leo.local.gym_exercises.domain.model.ExerciciosDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ExercicioMapper {

    public static ExerciciosDTO exerciciostoDTO(ExerciciosEntity entity) {
        if (entity == null) {
            return null;
        }

        ExerciciosDTO dto = new ExerciciosDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setDescricao(entity.getDescricao());
        dto.setGrupoMuscular(entity.getGrupoMuscular());
        dto.setEquipamento(entity.getEquipamento());

        return dto;
    }

}

