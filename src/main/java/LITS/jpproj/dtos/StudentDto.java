package LITS.jpproj.dtos;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class StudentDto {

    private Integer id;

    @NotNull
    private String username;

    private Integer age;

    private String faculty;

    private Integer course;

    private String city;

}
