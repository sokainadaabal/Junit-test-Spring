package controllers;

import com.geo.test.TestApplication;
import com.geo.test.controllers.StudentController;
import com.geo.test.dtos.StudentDto;
import com.geo.test.entites.Student;
import com.geo.test.mappers.StudentMapper;
import com.geo.test.services.StudentService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(StudentController.class)
@ContextConfiguration(classes = TestApplication.class) // Remplacez "YourApplication" par votre classe principale
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // Mock StudentService pour l'injecter dans le contexte Spring
    private StudentService studentService;

    @MockBean // Mock StudentMapper également si requis
    private StudentMapper studentMapper;

    @Test
    void addStudent() throws Exception {
        String studentJson = """
            {
                "id": 1,
                "name": "Daabal",
                "age": 12,
                "password": "daabal@19"
            }
            """;
        Student p = new Student(1L, "Daabal", 12L, "daabal@19");
        StudentDto studentDto = new StudentDto(1L, "Daabal", 12L);

        when(studentMapper.studentToStudentDto(p)).thenReturn(studentDto);
        when(studentService.addStudent(p)).thenReturn(studentDto);

        mockMvc.perform(post("/addStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void searchStudentById() throws Exception {
        Student p = new Student(1L, "sokaina", 12L, "daabal");
        StudentDto studentDto1 = new StudentDto(1L, "sokaina", 12L);
        when(studentMapper.studentToStudentDto(p)).thenReturn(studentDto1);
        when(studentService.searchStudent(p.getId())).thenReturn(studentDto1);

        mockMvc.perform(get("/id/" + p.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.age").value(12));
    }

    @Test
    void getAllStudent() throws Exception {
        StudentDto studentDto1 = new StudentDto(1L, "Daabal", 12L);
        StudentDto studentDto2 = new StudentDto(2L, "rachida", 15L);

        when(studentService.getAllStudent()).thenReturn(List.of(studentDto1, studentDto2));

        mockMvc.perform(get("/getAllStudent"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("Daabal"))
                .andExpect(jsonPath("$[0].age").value(12L))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].name").value("rachida"))
                .andExpect(jsonPath("$[1].age").value(15L));
    }

    @Test
    void shouldReturnUpdatedPerson() throws Exception {
        String json= """
                {
                "id":1,
                "name":"Sokaina",
                "age":12,
                "password":"daabal@19"
                }
                """;
        Student existingPerson = new Student(1L, "Daabal", 12L,"daabal@19");
        Student updatedPerson = new Student(1L, "Sokaina", 12L,"daabal@19");
        StudentDto studentDto= studentMapper.studentToStudentDto(existingPerson);
        when(studentService.searchStudent(1L)).thenReturn(studentDto);
        when(studentService.saveOrUpadteStudent(updatedPerson)).thenReturn(updatedPerson);

        mockMvc.perform(put("/update/1").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Sokaina"));
    }


    @Test
    void deleteStudent() throws Exception{
        StudentDto studentDto= new StudentDto(1L, "Daabal", 12L);
        when(studentService.searchStudent(studentDto.getId())).thenReturn(studentDto);

        mockMvc.perform(delete("/delete/1")).andExpect(status().isOk());
    }
}
