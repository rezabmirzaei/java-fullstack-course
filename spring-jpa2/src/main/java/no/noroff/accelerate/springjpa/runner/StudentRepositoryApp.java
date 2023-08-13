package no.noroff.accelerate.springjpa.runner;

import java.util.Collection;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import no.noroff.accelerate.springjpa.model.Student;
import no.noroff.accelerate.springjpa.repository.StudentRepository;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE) // Use to order multiple ApplicationRunners in same project
public class StudentRepositoryApp implements ApplicationRunner {

    private final StudentRepository studentRepository;

    public StudentRepositoryApp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("\n>>> StudentRepository.findAllByName():\n");
        Collection<Student> students = studentRepository.findAllByName("Frida");
        students.stream().forEach(stud -> System.out.println(stud.getName()));
        System.out.println();
    }
}
