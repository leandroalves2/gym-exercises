package leo.local.gym_exercises.repository;

import leo.local.gym_exercises.domain.entities.ExerciciosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciciosRepository extends JpaRepository<ExerciciosEntity, Long> {

    ExerciciosEntity findByNome(String nome);



}
