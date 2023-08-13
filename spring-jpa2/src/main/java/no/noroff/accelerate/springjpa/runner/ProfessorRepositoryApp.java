package no.noroff.accelerate.springjpa.runner;

import java.util.Collection;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import no.noroff.accelerate.springjpa.model.Professor;
import no.noroff.accelerate.springjpa.repository.ProfessorRepository;

@Component
public class ProfessorRepositoryApp implements ApplicationRunner {

    private final ProfessorRepository professorRepository;

    public ProfessorRepositoryApp(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("\n>>> ProfessorRepository.findAll():\n");
        Collection<Professor> professors = professorRepository.findAll();
        professors.stream().forEach(prof -> System.out.println(prof.getName()));
        System.out.println();
    }
}
