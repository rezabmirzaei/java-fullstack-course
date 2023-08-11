package no.noroff.accelerate.springjpa.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "tb_student")
public class Student {

    @Id
    @Column(name = "stud_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "stud_name", nullable = false, length = 50)
    private String name;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate birthday;

    @Column(name = "stud_type", length = 15)
    @Enumerated(EnumType.STRING)
    private StudentType type;

    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private Professor professor;

    @ManyToMany
    private Set<Subject> subjects;

    @Transient
    private String nickName; // Will not be persisted

}
