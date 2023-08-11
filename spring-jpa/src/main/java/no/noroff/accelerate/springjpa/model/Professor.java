package no.noroff.accelerate.springjpa.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prof_id")
    private int id;

    @Column(length = 50, nullable = false)
    private String name;

    @OneToMany(mappedBy = "professor")
    private Set<Subject> subjects;

    @OneToMany(mappedBy = "professor")
    private Set<Student> students;

}