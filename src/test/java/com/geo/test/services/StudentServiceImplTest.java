package com.geo.test.services;

import com.geo.test.dtos.StudentDto;
import com.geo.test.entites.Student;
import com.geo.test.mappers.StudentMapper;
import com.geo.test.mappers.StudentMapperImpl;
import com.geo.test.repositories.StudentRepository;
import com.geo.test.services.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest // pour charger toute le contexte de spring
class StudentServiceImplTest {
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentServiceImpl studentService;
    @Mock
    private StudentMapper studentMapper;
    @Test
    void addStudent() {

    }

    @Test
    void updateStudent() {
    }

    @Test
    void getAllStudent() {
        Student student1= new Student(1L,"sokaona",12L,"daabal");
        Student student2= new Student(2L,"rachida",15L,"mohammed");
        when(studentRepository.findAll()).thenReturn(List.of(student1,student2));

        List<StudentDto> students=studentService.getAllStudent();

        assertThat(students).hasSize(2).containsExactly(studentMapper.studentToStudentDto(student1),studentMapper.studentToStudentDto(student2));
    }

    @Test
    void serachStudent() {
    }
}