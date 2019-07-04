package LITS.jpproj.repository;

import LITS.jpproj.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student,Integer> {

    List<Student> getStudentByUsername(String username);
    List<Student> getByCity(String city);
    List<Student> getByUsernameAndAge(String username, Integer age);

}
