package leo.local.gym_exercises.repository;

import leo.local.gym_exercises.entities.ExercisesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercisesRepository extends JpaRepository<ExercisesEntity, Long> {
}
