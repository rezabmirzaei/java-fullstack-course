package no.noroff.accelerate.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import no.noroff.accelerate.springjpa.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
