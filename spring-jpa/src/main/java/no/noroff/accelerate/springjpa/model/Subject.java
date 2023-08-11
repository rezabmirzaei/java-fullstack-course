package no.noroff.accelerate.springjpa.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_subject")
public class Subject {

    @Id
    private int id;

    @Column(nullable = false, length = 5)
    private String code;

    @Column(nullable = false, length = 100)
    private String title;

    @ManyToMany(mappedBy = "subjects")
    private Set<Student> students;

}
