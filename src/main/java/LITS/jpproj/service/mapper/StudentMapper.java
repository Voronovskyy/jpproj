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

    public Student toEntity(StudentDto studentDto){
        return mappper.map(studentDto,Student.class);
    }

    public StudentDto toDto(Student student){
        return mappper.map(student,StudentDto.class);
    }

}
