package no.accelerate.postgrads.models.dtos.student;

import lombok.Data;

import java.util.Set;

@Data
public class StudentDTO {

    private int id;
    private String name;
    private int project;
    private int professor;
    private Set<Integer> subjects;

}
