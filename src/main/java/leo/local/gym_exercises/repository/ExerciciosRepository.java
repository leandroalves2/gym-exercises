package leo.local.gym_exercises.repository;

import leo.local.gym_exercises.entities.ExerciciosEntity;
import leo.local.gym_exercises.model.ExerciciosDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciciosRepository extends JpaRepository<ExerciciosEntity, Long> {

}
