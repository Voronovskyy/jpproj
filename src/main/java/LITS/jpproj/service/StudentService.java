package LITS.jpproj.service;

import LITS.jpproj.dtos.StudentDto;

import java.util.List;


public interface StudentService {

    StudentDto getById(Integer id);

    List<StudentDto> getAllStudents();

    StudentDto save(StudentDto student);

    List<StudentDto> getStudentByUsername(String username);

    List<StudentDto> getByCity(String city);

    List<StudentDto> getByUsernameAndAge(String username, Integer age);
}