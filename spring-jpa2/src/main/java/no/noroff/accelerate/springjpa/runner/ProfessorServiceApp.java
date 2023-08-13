package no.noroff.accelerate.springjpa.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import no.noroff.accelerate.springjpa.service.ProfessorService;

@Component
public class ProfessorServiceApp implements ApplicationRunner {

    private final ProfessorService professorService;

    public ProfessorServiceApp(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("\n>>> ProfessorService.deleteById():\n");
        professorService.deleteById(999); // No professor
        // professorService.deleteById(2);
        System.out.println();
    }
}
