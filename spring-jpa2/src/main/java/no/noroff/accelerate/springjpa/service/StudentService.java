package no.noroff.accelerate.springjpa.service;

import java.util.Collection;
import java.util.Set;

import no.noroff.accelerate.springjpa.model.Student;
import no.noroff.accelerate.springjpa.model.Subject;

public interface StudentService extends CrudService<Student, Integer> {

    void setProfessor(int studentId, int professorId);

    void setProject(int studentId, int projectId);

    Set<Subject> getSubjects(int studentId);

    Collection<Student> findAllByName(String name);

}
