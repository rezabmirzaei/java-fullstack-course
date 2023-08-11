package no.noroff.accelerate.springjpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_student")
public class Student {

    @Id
    @Column(name = "stud_id")
    private int id;

    @Column(name = "stud_name")
    private String name;

}
