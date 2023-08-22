package no.accelerate.postgrads.services.student;

import java.util.Collection;

import no.accelerate.postgrads.models.Student;
import no.accelerate.postgrads.services.CrudService;

/**
 * Service for the Student domain class.
 * Providing basic CRUD functionality through CrudService and any extended functionality.
 */
public interface StudentService extends CrudService<Student, Integer> {
    Collection<Student> findAllByName(String name);
}
