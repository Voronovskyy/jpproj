package LITS.jpproj.service.impl;

import LITS.jpproj.dtos.StudentDto;
import LITS.jpproj.entity.Student;
import LITS.jpproj.repository.StudentRepository;
import LITS.jpproj.service.StudentService;
import LITS.jpproj.service.mapper.PersonNotFoundException;
import LITS.jpproj.service.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service("dead")
public class DeadStudentService implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public StudentDto save(StudentDto studentDto) {
        Student entity = studentMapper.toEntity(studentDto);
        return studentMapper.toDto(studentRepository.save(entity));
    }

    @Override
    public StudentDto getById(Integer id) {
        Student one = studentRepository.findById(id).orElseThrow(()->new PersonNotFoundException("User with id "+id+" not found"));
        return studentMapper.toDto(one);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> list = (List<Student>) studentRepository.findAll();
        List<StudentDto> resultList = new ArrayList<>();

        if(list.isEmpty()){throw new PersonNotFoundException("There are no users");}

        for (Student student :list) {
            resultList.add(studentMapper.toDto(student));
        }
        return resultList;
    }

    @Override
    public List<StudentDto> getByCity(String city) {
        List<Student> resultList = studentRepository.getByCity(city);

        if(resultList.isEmpty()){ throw new PersonNotFoundException("User from city "+city+" not found");}

        return resultList
                .stream().filter(Objects::nonNull)
                .map(a->studentMapper.toDto(a))
                .collect(Collectors.toList());

    }

    @Override
    public List<StudentDto> getStudentByUsername(String username) {
        List<Student> resultList = studentRepository.getStudentByUsername(username);

        if(resultList.isEmpty()){throw new PersonNotFoundException("User with name "+username+" not found");}

        return resultList
                .stream().filter(Objects::nonNull)
                .map(a->studentMapper.toDto(a))
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> getByUsernameAndAge(String username, Integer age) {
        List<Student> resultList = studentRepository.getByUsernameAndAge(username,age);

        if(resultList.isEmpty()){throw new PersonNotFoundException("User with name "+username+" and age "+age+" not found");}

        return resultList.stream().filter(Objects::nonNull)
                .map(a->studentMapper.toDto(a))
                .collect(Collectors.toList());
    }
}
