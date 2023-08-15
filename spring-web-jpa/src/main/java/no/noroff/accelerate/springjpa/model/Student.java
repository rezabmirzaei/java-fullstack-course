package no.noroff.accelerate.springjpa.model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonGetter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)
    private String name;

    @OneToOne(mappedBy = "student")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToMany
    // @ManyToMany(fetch = FetchType.EAGER) // Don't really want this until needed
    @JoinTable(name = "student_subject", joinColumns = { @JoinColumn(name = "student_id") }, inverseJoinColumns = {
            @JoinColumn(name = "subject_id") })
    private Set<Subject> subjects;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    @JsonGetter("professor")
    public Integer jsonGetProfessor() {
        if (professor != null)
            return professor.getId();
        return null;
    }

    @JsonGetter("project")
    public Integer jsonGetProject() {
        if (project != null)
            return project.getId();
        return null;
    }

    @JsonGetter("subjects")
    public List<Integer> jsonGetSubjects() {
        if (subjects != null)
            return subjects.stream().map(s -> s.getId())
                    .collect(Collectors.toList());
        return null;
    }

}
