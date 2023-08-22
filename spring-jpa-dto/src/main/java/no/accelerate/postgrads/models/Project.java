package no.accelerate.postgrads.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * Domain class (entity) to represent a Project.
 * Includes an auto generated key and some validation.
 * Relationships are configured as default, so collections are lazily loaded.
 */
@Entity
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @OneToOne(mappedBy = "project")
    private Student student;

}
