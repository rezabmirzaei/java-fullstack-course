package no.noroff.accelerate.springjpa.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_professor")
public class Professor {

    @Id
    @Column(name = "prof_id")
    private int id;

    @Column(nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "professor")
    private Set<Student> students;

}
