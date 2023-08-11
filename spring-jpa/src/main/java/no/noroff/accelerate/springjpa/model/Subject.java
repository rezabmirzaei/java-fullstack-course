package no.noroff.accelerate.springjpa.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 6, nullable = false)
    private String code;

    @Column(length = 100, nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    private Professor professor;

    @ManyToMany(mappedBy = "subjects")
    private Set<Student> students;

}