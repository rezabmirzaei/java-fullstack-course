package no.accelerate.postgrads.services.professor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import no.accelerate.postgrads.exceptions.ProfessorNotFoundException;
import no.accelerate.postgrads.models.Professor;
import no.accelerate.postgrads.repositories.ProfessorRepository;

import java.util.Collection;

/**
 * Implementation of the Professor service.
 * Uses the Professor repository to interact with the data store.
 * Logs errors through the standard logger.
 */
@Service
public class ProfessorServiceImpl implements ProfessorService {

    private final Logger logger = LoggerFactory.getLogger(ProfessorServiceImpl.class);
    private final ProfessorRepository professorRepository;

    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        if (professorRepository.existsById(id)) {
            // Set relationships to null so we can delete without referential problems
            Professor prof = professorRepository.findById(id).get();
            prof.getStudents().forEach(s -> s.setProfessor(null));
            prof.getSubjects().forEach(s -> s.setProfessor(null));
            professorRepository.delete(prof);
        } else
            logger.warn("No professor exists with ID: " + id);
    }

    @Override
    public boolean exists(Integer id) {
        return professorRepository.existsById(id);
    }

    @Override
    public Professor findById(Integer id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new ProfessorNotFoundException(id));
    }

    @Override
    public Collection<Professor> findAll() {
        return professorRepository.findAll();
    }

    @Override
    public Professor add(Professor entity) {
        return professorRepository.save(entity);
    }

    @Override
    public Professor update(Professor entity) {
        return professorRepository.save(entity);
    }

}
