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
//        Student build = Student.builder().age(13).build();
        return studentMapper.toDto(studentRepository.save(entity));
    }

    @Override
    public List<StudentDto> getStudentByNameAndAge(String name, Integer age) {
//        EntityManager entityManager;
//        List<StudentDto> list = studentRepository.getStudentByNameAndAge(name,age);
////        Query query = new Query();
//        return list;
//        List<StudentDto> resultList = studentRepository.getStudentByNameAndAge(name,age).
//                stream().

        return null;

    }

    @Override
    public StudentDto getByCity(String city) {
//        return studentRepository.getByCity(city);
//        log.
        return null;
    }
}
