package com.example.repository;

import LITS.jpproj.entity.Student;
import LITS.jpproj.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void whenGetByName_thenReturnStudent(){
        Student student = new Student();
        student.setUsername("Danylo");

        testEntityManager.persist(student);
        testEntityManager.flush();

        List<Student> list = studentRepository.getStudentByUsername(student.getUsername());

        assertThat(list.get(1).getUsername())
                .isEqualTo(student.getUsername());
    }

    @Test
    public void whenGetByCity_thenReturnStudent(){
        Student student = new Student();
        student.setCity("Lviv");

        testEntityManager.persist(student);
        testEntityManager.flush();

        List<Student> list = studentRepository.getByCity(student.getCity());

        assertThat(list.get(1).getCity())
                .isEqualTo(student.getCity());
    }

    @Test
    public void whenGetByUserNameAndAge_thenReturnStudent(){
        Student student = new Student();
        student.setUsername("Danylo");
        student.setAge(18);

        testEntityManager.persist(student);
        testEntityManager.flush();

        List<Student> list = studentRepository.getByUsernameAndAge(student.getUsername(),student.getAge());

        assertThat(list.get(1).getUsername())
                .isEqualTo(student.getUsername());
        assertThat(list.get(1).getAge())
                .isEqualTo(student.getAge());
    }

}
