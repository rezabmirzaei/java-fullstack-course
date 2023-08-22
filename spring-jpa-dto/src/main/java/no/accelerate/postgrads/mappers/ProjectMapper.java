package no.accelerate.postgrads.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import no.accelerate.postgrads.models.Project;
import no.accelerate.postgrads.models.dtos.project.ProjectDTO;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectDTO projectToProjectDto(Project project);
    // Mapping the other way
    @Mapping(target = "student", ignore = true)
    Project projectDtoToProject(ProjectDTO projectDTO);
}
