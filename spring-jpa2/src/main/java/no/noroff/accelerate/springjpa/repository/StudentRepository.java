package no.noroff.accelerate.springjpa.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import no.noroff.accelerate.springjpa.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("select s from Student s where s.name like %?1%")
    Set<Student> findAllByName(String name);

    @Modifying
    @Query("update Student s set s.professor.id = ?2 where s.id = ?1")
    void updateProfessorById(int studentId, int professorId);

    @Modifying
    @Query("update Student s set s.project.id = ?2 where s.id = ?1")
    void updateProjectById(int studentId, int professorId);

}
