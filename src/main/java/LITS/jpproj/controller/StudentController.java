package LITS.jpproj.controller;

import LITS.jpproj.dtos.StudentDto;
import LITS.jpproj.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
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
    @ApiOperation("saveStudent")
    public StudentDto saveStudent(@RequestBody StudentDto studentDto){
        return aliveStudentService.save(studentDto);
    }

    @GetMapping(value = "/allUsers")
    @ApiOperation("getAllStudents")
    public List<StudentDto> getAllStudents(){
        return aliveStudentService.getAllStudents();
    }

    @GetMapping(value = "/users")
    @ApiOperation("getPersonById")
    public StudentDto getStudentById(@RequestParam Integer id){
        return aliveStudentService.getById(id);
    }

    @GetMapping(value = "/getUserByName")
    @ApiOperation("getStudentByNameAndAge")
    public List<StudentDto> getStudentByUsername(@RequestParam String username){
        return aliveStudentService.getStudentByUsername(username);
    }

    @GetMapping(value = "/getUserByCity")
    @ApiOperation("getUserByCity")
    public List<StudentDto> getStudentByCity(@RequestParam String city){
        return aliveStudentService.getByCity(city);
    }

    @GetMapping(value = "/getUserByUsernameAndAge")
    public List<StudentDto> getStudentByUsernameAndAge(@RequestParam String username, Integer age){
        return aliveStudentService.getByUsernameAndAge(username,age);
    }

}
