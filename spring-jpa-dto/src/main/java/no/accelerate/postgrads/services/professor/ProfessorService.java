package no.accelerate.postgrads.services.professor;

import no.accelerate.postgrads.models.Professor;
import no.accelerate.postgrads.services.CrudService;

/**
 * Service for the Professor domain class.
 * Providing basic CRUD functionality through CrudService and any extended functionality.
 */
public interface ProfessorService extends CrudService<Professor, Integer> {
}
