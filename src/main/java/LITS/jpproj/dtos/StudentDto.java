package LITS.jpproj.dtos;

import lombok.Data;

@Data
public class StudentDto {
    private Integer id;
    private String username;
    private Integer age;
    private String faculty;
    private Integer course;
    private String city;

}
