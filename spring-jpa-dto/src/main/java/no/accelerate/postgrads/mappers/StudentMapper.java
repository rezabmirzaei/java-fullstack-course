package no.accelerate.postgrads.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import no.accelerate.postgrads.models.Professor;
import no.accelerate.postgrads.models.Project;
import no.accelerate.postgrads.models.Student;
import no.accelerate.postgrads.models.Subject;
import no.accelerate.postgrads.models.dtos.student.StudentDTO;
import no.accelerate.postgrads.services.professor.ProfessorService;
import no.accelerate.postgrads.services.project.ProjectService;
import no.accelerate.postgrads.services.subject.SubjectService;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class StudentMapper {

    @Autowired
    protected ProjectService projectService;
    @Autowired
    protected ProfessorService professorService;
    @Autowired
    protected SubjectService subjectService;

    @Mapping(target = "project", source = "project.id")
    @Mapping(target = "professor", source = "professor.id")
    @Mapping(target = "subjects", source = "subjects", qualifiedByName = "subjectsToIds")
    public abstract StudentDTO studentToStudentDto(Student student);

    public abstract Collection<StudentDTO> studentToStudentDto(Collection<Student> students);

    @Mapping(target = "project", source = "project", qualifiedByName = "projectIdToProject")
    @Mapping(target = "professor", source = "professor", qualifiedByName = "professorIdToProfessor")
    @Mapping(target = "subjects", source = "subjects", qualifiedByName = "subjectIdsToSubjects")
    public abstract Student studentDtoToStudent(StudentDTO dto);

    // Custom mappings
    @Named("projectIdToProject")
    Project mapIdToProject(int id) {
        if (!projectService.exists(id)) {
            return null;
        }
        return projectService.findById(id);
    }

    @Named("professorIdToProfessor")
    Professor mapIdToProfessor(int id) {
        return professorService.findById(id);
    }

    @Named("subjectIdsToSubjects")
    Set<Subject> mapIdsToSubjects(Set<Integer> id) {
        return id.stream()
                .map(i -> subjectService.findById(i))
                .collect(Collectors.toSet());
    }

    @Named("subjectsToIds")
    Set<Integer> mapSubjectsToIds(Set<Subject> source) {
        if (source == null)
            return null;
        return source.stream()
                .map(s -> s.getId()).collect(Collectors.toSet());
    }

}
