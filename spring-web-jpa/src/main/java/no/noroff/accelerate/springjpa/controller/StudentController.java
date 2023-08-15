package no.noroff.accelerate.springjpa.controller;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import no.noroff.accelerate.springjpa.model.Student;
import no.noroff.accelerate.springjpa.service.StudentService;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Operation(summary = "Get all students")
    @GetMapping // GET: localhost:8080/api/v1/students
    public ResponseEntity<Collection<Student>> getAll() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("{id}") // GET: localhost:8080/api/v1/students/1
    public ResponseEntity<Student> getById(@PathVariable int id) {
        return ResponseEntity.ok(studentService.findById(id));
    }

    @PostMapping // POST: localhost:8080/api/v1/students
    public ResponseEntity<Student> add(@RequestBody Student student) {
        Student stud = studentService.add(student);
        URI location = URI.create("students/" + stud.getId());
        return ResponseEntity.created(location).build();
    }

}
