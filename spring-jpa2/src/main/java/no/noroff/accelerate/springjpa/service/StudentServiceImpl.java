package no.noroff.accelerate.springjpa.service;

import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.noroff.accelerate.springjpa.model.Student;
import no.noroff.accelerate.springjpa.model.Subject;
import no.noroff.accelerate.springjpa.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Collection<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student add(Student entity) {
        return studentRepository.save(entity);
    }

    @Override
    public Student update(Student entity) {
        return studentRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void setProfessor(int studentId, int professorId) {
        studentRepository.updateProfessorById(studentId, professorId);
    }

    @Override
    public void setProject(int studentId, int projectId) {
        studentRepository.updateProjectById(studentId, projectId);
    }

    @Override
    public Set<Subject> getSubjects(int studentId) {
        return studentRepository.findById(studentId).get().getSubjects();
    }

    @Override
    public Collection<Student> findAllByName(String name) {
        return studentRepository.findAllByName(name);
    }

}