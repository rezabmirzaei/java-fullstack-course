package no.accelerate.postgrads.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import no.accelerate.postgrads.models.Professor;

/**
 * Repository (DAO) for the Professor domain class.
 * Uses @Query for business logic that is difficult to achieve with default functionality.
 */
@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    @Modifying
    @Query("update Student s set s.professor.id = ?2 where s.id = ?1")
    void updateProfessorById(int studentId, int professorId);

}
