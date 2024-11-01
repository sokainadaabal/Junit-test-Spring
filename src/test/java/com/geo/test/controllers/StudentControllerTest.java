package controllers;

import com.geo.test.controllers.StudentController;
import com.geo.test.dtos.StudentDto;
import com.geo.test.entites.Student;
import com.geo.test.mappers.StudentMapper;
import com.geo.test.services.StudentService;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import java.util.List;


import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(StudentController.class)  // tester les contrôleurs Spring MVC sans démarrer tout le contexte d'application
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // injecter ce bean dans le contexte de spring
    private StudentService studentService;

    @Mock
    private StudentMapper studentMapper;

    @Test
    void getAllStudent() throws Exception {
        Student student1= new Student(1L,"sokaina",12L,"daabal");
        Student student2= new Student(2L,"mohammed",12L,"daabal");

       when(studentService.getAllStudent()).thenReturn(List.of(studentMapper.studentToStudentDto(student1), studentMapper.studentToStudentDto(student2)));

      mockMvc.perform(get("/getAllUser"))
              .andExpect(status().isOk()).andExpect(jsonPath("$[0].name").value("sokaina"));

    }
}