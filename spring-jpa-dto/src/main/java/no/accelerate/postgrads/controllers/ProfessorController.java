package no.accelerate.postgrads.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import no.accelerate.postgrads.models.Professor;
import no.accelerate.postgrads.services.professor.ProfessorService;

import java.util.Collection;

// TODO Heads up! Not fuly implemented.

@RestController
@RequestMapping(path = "api/v1/professors")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public ResponseEntity<Collection<Professor>> getAll() {
        return ResponseEntity.ok(professorService.findAll());
    }

    @PostMapping
    public ResponseEntity<Professor> add(@RequestBody Professor professor) {
        professorService.add(professor);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
