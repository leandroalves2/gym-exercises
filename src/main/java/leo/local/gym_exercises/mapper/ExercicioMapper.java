package leo.local.gym_exercises.mapper;

import leo.local.gym_exercises.entities.ExerciciosEntity;
import leo.local.gym_exercises.model.ExerciciosDTO;

// ExercicioMapper.java
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

