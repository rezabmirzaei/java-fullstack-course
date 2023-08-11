package no.noroff.accelerate.springjpa.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_student")
public class Student {

    @Id
    @Column(name = "stud_id")
    private int id;

    @Column(name = "stud_name", nullable = false, length = 50)
    private String name;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate birthday;

    @Column(name = "stud_type", length = 15)
    @Enumerated(EnumType.STRING)
    private StudentType type;

}
