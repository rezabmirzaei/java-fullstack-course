package no.noroff.accelerate.springjpa.service;

import java.util.Collection;

import no.noroff.accelerate.springjpa.model.Student;

public interface StudentService extends CrudService<Student, Integer> {

    void setProfessor(int studentId, int professorId);

    void setProject(int studentId, int projectId);

    Collection<Student> findAllByName(String name);

}
