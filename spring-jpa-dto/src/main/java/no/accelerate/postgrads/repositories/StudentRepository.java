package no.accelerate.postgrads.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import no.accelerate.postgrads.models.Student;

/**
 * Repository (DAO) for the Student domain class.
 * Uses @Query for business logic that is difficult to achieve with default functionality.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("select s from Student s where s.name like %?1%")
    Set<Student> findAllByName(String name);

}
