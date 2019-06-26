package LITS.jpproj.controller;

import LITS.jpproj.dtos.StudentDto;
import LITS.jpproj.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class StudentController {

    @Autowired
    @Qualifier(value = "alive")
    private StudentService aliveStudentService;

    @Autowired
    @Qualifier(value = "dead")
    private StudentService deadStudentService;

    @PostMapping
    public StudentDto saveStudent(@RequestBody StudentDto studentDto){
        return aliveStudentService.save(studentDto);
    }

    @GetMapping(value = "/allUsers")
    public List<StudentDto> getAllStudents(){
        return aliveStudentService.getAllStudents();
    }

    @GetMapping(value = "/users")
    public StudentDto getPersonById(@RequestParam Integer id){
        return aliveStudentService.getById(id);
    }

    @GetMapping(value = "/usersByNameAndAge")
    public List<StudentDto> getStudentByNameAndAge(@RequestParam String name , @RequestParam Integer age){
        return aliveStudentService.getStudentByNameAndAge(name,age);
    }

    @GetMapping(value = "/getUserByCity")
    public StudentDto getByCity(@RequestParam String city){
        return aliveStudentService.getByCity(city);
    }
}
