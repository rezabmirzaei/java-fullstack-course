package no.noroff.accelerate.springjpa.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import no.noroff.accelerate.springjpa.model.Professor;
import no.noroff.accelerate.springjpa.repository.ProfessorRepository;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    private final Logger logger = LoggerFactory.getLogger(ProfessorServiceImpl.class);
    private final ProfessorRepository professorRepository;

    @Autowired
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
    public Professor findById(Integer id) {
        return professorRepository.findById(id).get();
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
