package com.example.controller;

import LITS.jpproj.JpprojApplication;
import LITS.jpproj.controller.StudentController;
import LITS.jpproj.entity.Student;
import LITS.jpproj.repository.StudentRepository;
import com.example.config.MockConfiguration;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Map;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpprojApplication.class)
@ContextConfiguration(classes ={MockConfiguration.class})
public class StudentControllerIntegrationTest {

    private static final String API_STUDENTS = "/api";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentController studentController;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void shouldSuccessStudent()throws Exception{
        Student student = new Student();
        student.setUsername("Username");

        JSONObject jsonObject = new JSONObject((Map) student);

        mockMvc.perform(post(API_STUDENTS)
        .accept("application/json")
        .contentType(MediaType.APPLICATION_JSON)
        .content(student.toString()))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void getStudentWithQueryParameterId_whenMockMVC_thenResponseOK() throws Exception {
        this.mockMvc.perform(get("/api/users")
                .param("id", "1")).andDo(print()).andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType("application/json;charset=UTF-8"))
                .andExpect((ResultMatcher) jsonPath("$.name").value("somePerson"));
    }

}
