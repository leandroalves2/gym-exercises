package leo.local.gym_exercises.repository;

import leo.local.gym_exercises.domain.entities.TreinoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinoRepository extends JpaRepository<TreinoEntity, Long> {
}
