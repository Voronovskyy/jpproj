package LITS.jpproj.service;

import LITS.jpproj.dtos.StudentDto;

import java.util.List;


public interface StudentService {
    StudentDto getById(Integer id);

    List<StudentDto> getAllStudents();

    StudentDto save(StudentDto student);

    List<StudentDto> getStudentByNameAndAge(String name, Integer id);

    StudentDto getByCity(String city);
}