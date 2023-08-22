package no.accelerate.postgrads.controllers;

import java.net.URI;
import java.util.Collection;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import no.accelerate.postgrads.mappers.StudentMapper;
import no.accelerate.postgrads.models.Student;
import no.accelerate.postgrads.models.dtos.student.StudentDTO;
import no.accelerate.postgrads.services.student.StudentService;
import no.accelerate.postgrads.util.ApiErrorResponse;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;

    public StudentController(StudentService studentService, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    @Operation(summary = "Get all students")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StudentDTO.class))) }),
            @ApiResponse(responseCode = "404", description = "Student does not exist with supplied ID", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping // GET: localhost:8080/api/v1/students
    public ResponseEntity<Collection<StudentDTO>> getAll() {
        Collection<StudentDTO> studs = studentMapper.studentToStudentDto(studentService.findAll());
        return ResponseEntity.ok(studs);
    }

    @Operation(summary = "Get a student by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = StudentDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Student does not exist with supplied ID", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping("{id}") // GET: localhost:8080/api/v1/students/1
    public ResponseEntity<StudentDTO> getById(@PathVariable int id) {
        StudentDTO stud = studentMapper.studentToStudentDto(studentService.findById(id));
        return ResponseEntity.ok(stud);
    }

    @GetMapping("search") // GET: localhost:8080/api/v1/students/search?name=Ola
    public ResponseEntity<Collection<Student>> findByName(@RequestParam String name) {
        return ResponseEntity.ok(studentService.findAllByName(name));
    }

    @Operation(summary = "Adds new Student")
    @PostMapping // POST: localhost:8080/api/v1/students
    public ResponseEntity<Void> add(@RequestBody Student student) {
        Student stud = studentService.add(student);
        URI location = URI.create("students/" + stud.getId());
        return ResponseEntity.created(location).build();
    }

    @Operation(summary = "Updates a student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Student successfully updated", content = @Content),
            @ApiResponse(responseCode = "400", description = "Malformed request", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorAttributeOptions.class)) }),
            @ApiResponse(responseCode = "404", description = "Student not found with supplied ID", content = @Content)
    })
    @PutMapping("{id}") // PUT: localhost:8080/api/v1/students/1
    public ResponseEntity<Void> update(@RequestBody StudentDTO studentDTO, @PathVariable int id) {
        // Validates if body is correct
        if (id != studentDTO.getId()) {
            return ResponseEntity.badRequest().build();
        }
        studentService.update(studentMapper.studentDtoToStudent(studentDTO));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}") // DELETE: localhost:8080/api/v1/students/1
    public ResponseEntity<Void> delete(@PathVariable int id) {
        studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
