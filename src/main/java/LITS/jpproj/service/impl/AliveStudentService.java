package LITS.jpproj.service.impl;

import LITS.jpproj.dtos.StudentDto;
import LITS.jpproj.entity.Student;
import LITS.jpproj.repository.StudentRepository;
import LITS.jpproj.service.StudentService;
import LITS.jpproj.service.mapper.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service("alive")
@Slf4j
public class AliveStudentService implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public StudentDto getById(Integer id) {
        return studentMapper.toDto(studentRepository.getOne(id));
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> list = studentRepository.findAll();
        List<StudentDto> resultList = new ArrayList<>();
        for (Student student :list) {
            resultList.add(studentMapper.toDto(student));
        }
        return resultList;
    }

    @Override
    public StudentDto save(StudentDto studentDto) {
        Student entity = studentMapper.toEntity(studentDto);
        return studentMapper.toDto(studentRepository.save(entity));
    }

    @Override
    public List<StudentDto> getByCity(String city) {
        List<Student> resultList = studentRepository.getByCity(city);
        return resultList
                .stream().filter(Objects::nonNull)
                .map(a->studentMapper.toDto(a))
                .collect(Collectors.toList());

    }

    @Override
    public List<StudentDto> getStudentByUsername(String username) {
        List<Student> resultList = studentRepository.getStudentByUsername(username);
        return resultList
                .stream().filter(Objects::nonNull)
                .map(a->studentMapper.toDto(a))
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> getByUsernameAndAge(String username, Integer age) {
        List<Student> resultList = studentRepository.getByUsernameAndAge(username,age);
        return resultList.stream().filter(Objects::nonNull)
                .map(a->studentMapper.toDto(a))
                .collect(Collectors.toList());
    }

}
