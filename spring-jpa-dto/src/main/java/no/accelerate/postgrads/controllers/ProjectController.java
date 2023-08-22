package no.accelerate.postgrads.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import no.accelerate.postgrads.mappers.ProjectMapper;
import no.accelerate.postgrads.models.dtos.project.ProjectDTO;
import no.accelerate.postgrads.services.project.ProjectService;
import no.accelerate.postgrads.util.ApiErrorResponse;

@RestController
@RequestMapping(path = "api/v1/projects")
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectMapper projectMapper;

    public ProjectController(ProjectService projectService, ProjectMapper projectMapper) {
        this.projectService = projectService;
        this.projectMapper = projectMapper;
    }

    @Operation(summary = "Get a project by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ProjectDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Project does not exist with supplied ID", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping("{id}")
    public ResponseEntity<ProjectDTO> findById(@PathVariable int id) {
        ProjectDTO proj = projectMapper.projectToProjectDto(
                projectService.findById(id));
        return ResponseEntity.ok(proj);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProjectDTO> updateProject(@RequestBody ProjectDTO projectDTO, @PathVariable int id) {
        if (id != projectDTO.getId())
            return ResponseEntity.notFound().build();
        projectService.update(
                projectMapper.projectDtoToProject(projectDTO));
        return ResponseEntity.noContent().build();
    }

}
