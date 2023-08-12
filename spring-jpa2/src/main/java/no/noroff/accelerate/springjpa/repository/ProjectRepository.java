package no.noroff.accelerate.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import no.noroff.accelerate.springjpa.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
