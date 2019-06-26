package LITS.jpproj.repository;

import LITS.jpproj.dtos.StudentDto;
import LITS.jpproj.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<StudentDto> getStudentByNameAndAge(String name, Integer age);
//    StudentDto getByCity(String city);
}
