package no.noroff.accelerate.springjpa.runner;

import java.util.Collection;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import no.noroff.accelerate.springjpa.model.Student;
import no.noroff.accelerate.springjpa.service.StudentService;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE) // Use to order multiple ApplicationRunners in same project
public class StudentApp implements ApplicationRunner {

    private final StudentService studentService;

    public StudentApp(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Collection<Student> students = studentService.findAll();
        students.stream().forEach(stud -> System.out.println(stud.getName()));
        // professorService.deleteById(1);
    }
}
