package com.example.service;

import LITS.jpproj.dtos.StudentDto;
import LITS.jpproj.entity.Student;
import LITS.jpproj.repository.StudentRepository;
import LITS.jpproj.service.impl.AliveStudentService;
import LITS.jpproj.service.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StudentService {

    @Mock
    private StudentRepository studentRepositoryMock;

    @Mock
    private StudentMapper studentMapperMock;

    @InjectMocks
    AliveStudentService aliveStudentService = new AliveStudentService();

    @Test

    public void shouldSaveStudent(){
        StudentDto studentDto = new StudentDto();
        Student student = new Student();
        when(studentMapperMock.toEntity(studentDto)).thenReturn(student);
        aliveStudentService.save(studentDto);

        student.setUsername("Danylo");
        when(studentMapperMock.toEntity(studentDto)).thenReturn(student);
        when(aliveStudentService.save(studentDto)).thenReturn(studentDto);

        assertNotNull(aliveStudentService.save(studentDto));

    }

    @Test
    public void shouldGetStudentById(){
        StudentDto studentDto = new StudentDto();
        studentDto.setId(1);
        when(aliveStudentService.getById(studentDto.getId())).thenReturn(studentDto);

        assertNotNull(aliveStudentService.getById(studentDto.getId()));
    }


    @Test
    public void shouldGetAllStudent(){
        StudentDto studentDto = new StudentDto();
        when(studentMapperMock.toEntity(studentDto)).thenReturn(new Student());
        aliveStudentService.save(studentDto);
        studentDto.setUsername("Voronovsky");

//        when(studentRepositoryMock.findAll()).thenReturn(new ArrayList<>());

        List<Student> list = studentRepositoryMock.findAll();
        List<StudentDto> resultList = new ArrayList<>();
        for(Student student : list){
            resultList.add(studentMapperMock.toDto(student));
        }

        assertNotNull(resultList);

    }
}
