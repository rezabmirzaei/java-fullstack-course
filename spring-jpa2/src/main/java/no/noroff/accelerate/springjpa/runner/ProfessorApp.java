package no.noroff.accelerate.springjpa.runner;

import java.util.Collection;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import no.noroff.accelerate.springjpa.model.Professor;
import no.noroff.accelerate.springjpa.service.ProfessorService;

@Component
public class ProfessorApp implements ApplicationRunner {

    private final ProfessorService professorService;

    public ProfessorApp(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Collection<Professor> professors = professorService.findAll();
        professors.stream().forEach(prof -> System.out.println(prof.getName()));
        // professorService.deleteById(1);
    }
}
