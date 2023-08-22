package no.accelerate.postgrads.services.student;

import java.util.Collection;

import org.springframework.stereotype.Service;

import no.accelerate.postgrads.exceptions.StudentNotFoundException;
import no.accelerate.postgrads.models.Student;
import no.accelerate.postgrads.repositories.StudentRepository;

/**
 * Implementation of the Student service.
 * Uses the Student repository to interact with the data store.
 * Logs errors through the standard logger.
 */
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
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
    public boolean exists(Integer id) {
        return studentRepository.existsById(id);
    }

    @Override
    public Collection<Student> findAllByName(String name) {
        return studentRepository.findAllByName(name);
    }

}
