package LITS.jpproj.repository;

import LITS.jpproj.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student,Integer> {

    List<Student> getStudentByUsername(String username);
    List<Student> getByCity(String city);
    List<Student> getByUsernameAndAge(String username, Integer age);

}
