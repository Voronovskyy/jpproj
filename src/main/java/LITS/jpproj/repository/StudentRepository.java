package LITS.jpproj.repository;

import LITS.jpproj.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface StudentRepository extends CrudRepository<Student,Integer> {

    //toDo change to CrudRepository
    List<Student> getStudentByUsername(String username);
    List<Student> getByCity(String city);
    List<Student> getByUsernameAndAge(String username, Integer age);

}
