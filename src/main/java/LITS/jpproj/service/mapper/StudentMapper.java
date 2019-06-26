package LITS.jpproj.service.mapper;

import LITS.jpproj.dtos.StudentDto;
import LITS.jpproj.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    @Autowired
    private ModelMapper mappper;

//    public Student toEntity(StudentDto studentDto){
//        Student student = new Student();
//        student.setId(studentDto.getId());
//        student.setUsername(studentDto.getUsername());
//        student.setAge(studentDto.getAge());
//        student.setFaculty(studentDto.getFaculty());
//        student.setCourse(studentDto.getCourse());
//
//        return student;
//    }
//
//    public StudentDto toDto(Student student){
//        StudentDto studentDto = new StudentDto();
//        studentDto.setId(student.getId());
//        studentDto.setUsername(student.getUsername());
//        studentDto.setAge(student.getAge());
//        studentDto.setFaculty(student.getFaculty());
//        studentDto.setCourse(student.getCourse());
//
//        return studentDto;
//    }

    public Student toEntity(StudentDto studentDto){
        return mappper.map(studentDto,Student.class);
    }

    public StudentDto toDto(Student student){
        return mappper.map(student,StudentDto.class);
    }

    private void test(){
        Student student = new Student();
        StudentDto studentDto = new StudentDto();
        mappper.map(student,studentDto);
    }

}
