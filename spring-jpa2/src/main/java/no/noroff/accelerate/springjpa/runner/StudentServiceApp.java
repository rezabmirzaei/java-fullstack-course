package no.noroff.accelerate.springjpa.runner;

import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;
import no.noroff.accelerate.springjpa.model.Subject;
import no.noroff.accelerate.springjpa.service.StudentService;

@Component
public class StudentServiceApp implements ApplicationRunner {

    private final StudentService studentService;

    public StudentServiceApp(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    @Transactional // Needed to handle lazy loading issues with subjects
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("\n>>> StudentService.getSubjects(int studentId):\n");
        Set<Subject> subjects = studentService.getSubjects(2);
        subjects.stream().forEach(sub -> System.out.println(sub.getTitle()));
        System.out.println();
    }
}
