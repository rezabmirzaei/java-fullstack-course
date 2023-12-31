package no.noroff.accelerate.springjpa.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import no.noroff.accelerate.springjpa.model.Professor;
import no.noroff.accelerate.springjpa.repository.ProfessorRepository;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {

        // This will fail because it violates foreign key constraints 
        // Professor prof = professorRepository.findById(id).get();
        // professorRepository.delete(prof);

        if (professorRepository.existsById(id)) {
            // Set relationships to null so we can delete without referential problems
            Professor prof = professorRepository.findById(id).get();
            prof.getStudents().forEach(s -> s.setProfessor(null));
            prof.getSubjects().forEach(s -> s.setProfessor(null));
            professorRepository.delete(prof);
        } else {
            System.out.println("No professor exists with ID: " + id);
        }
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
