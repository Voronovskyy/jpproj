package LITS.jpproj.service.impl;

import LITS.jpproj.dtos.StudentDto;
import LITS.jpproj.entity.Student;
import LITS.jpproj.repository.StudentRepository;
import LITS.jpproj.service.StudentService;
import LITS.jpproj.service.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("dead")
public class DeadStudentService implements StudentService {

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
    public StudentDto getByCity(String city) {
//        List<StudentDto> resultList = studentRepository.getByCity(city);
//        return (StudentDto) resultList
//                .stream()
//                .map(a->studentMapper.toEntity(a))
//                .collect(Collectors.toList());
        return null;
    }

    @Override
    public StudentDto getStudentByNameAndAge(String name, Integer age) {
//        List<StudentDto> resultList = studentRepository.getStudentByNameAndAge(name,age);
//        return (StudentDto) resultList
//                .stream()
//                .map(a->studentMapper.toEntity(a))
//                .collect(Collectors.toList());
        return null;
    }
}
