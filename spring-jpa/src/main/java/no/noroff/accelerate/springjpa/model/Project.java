package no.noroff.accelerate.springjpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_project")
public class Project {

    @Id
    @Column(name = "proj_id")
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @OneToOne(mappedBy = "project")
    private Student student;
    
}
