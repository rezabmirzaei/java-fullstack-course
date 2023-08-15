package no.noroff.accelerate.springjpa.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import no.noroff.accelerate.springjpa.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM Student s WHERE s.name LIKE %?1%")
    Set<Student> findAllByName(String name);

    @Modifying
    @Query("UPDATE Student s SET s.professor.id = ?2 WHERE s.id = ?1")
    void updateProfessorById(int studentId, int professorId);

    @Modifying
    @Query("UPDATE Student s SET s.project.id = ?2 WHERE s.id = ?1")
    void updateProjectById(int studentId, int professorId);

}
