package no.accelerate.postgrads.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import no.accelerate.postgrads.models.Subject;

/**
 * Repository (DAO) for the Professor domain class.
 * Uses @Query for business logic that is difficult to achieve with default functionality.
 */
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
