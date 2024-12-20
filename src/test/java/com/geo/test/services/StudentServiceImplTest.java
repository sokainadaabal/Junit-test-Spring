package com.geo.test.services;

import com.geo.test.dtos.StudentDto;
import com.geo.test.entites.Student;
import com.geo.test.exceptions.StudentNotFoundException;
import com.geo.test.mappers.StudentMapper;
import com.geo.test.repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.verify;
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
             Student student1=new Student(1L,"sokaina",12L,"daabal");
             StudentDto studentDto=studentService.addStudent(student1);
             assertThat(studentDto).isEqualTo(studentMapper.studentToStudentDto(student1));
    }

    @Test
    void updateStudent() {
        Student student1= new Student(1L,"sokaina",12L,"daabal");
        Student student2= new Student(1L,"rachida",15L,"mohammed");
        when(studentRepository.save(student1)).thenReturn(student1);
        StudentDto studentDto= studentService.updateStudent(student2);
        assertThat(studentDto).isEqualTo(studentMapper.studentToStudentDto(student2));
    }

    @Test
    void getAllStudent() {
        Student student1= new Student(1L,"sokaina",12L,"daabal");
        Student student2= new Student(2L,"rachida",15L,"mohammed");
        when(studentRepository.findAll()).thenReturn(List.of(student1,student2));

        List<StudentDto> students=studentService.getAllStudent();

        assertThat(students).hasSize(2).containsExactly(studentMapper.studentToStudentDto(student1),studentMapper.studentToStudentDto(student2));
    }

    @Test
    void searchStudent() {
        Student student1= new Student(1L,"sokaina",12L,"daabal");
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student1));
        StudentDto studentDto= null;
        try {
            studentDto = studentService.searchStudent(student1.getId());
        } catch (StudentNotFoundException e) {
            throw new RuntimeException(e);
        }
        assertThat(studentDto).isEqualTo(studentMapper.studentToStudentDto(student1));
    }

    @Test
    void returnSaveOrUpdateStudent(){
        Student student1= new Student(1L,"sokaina",12L,"daabal");
        when(studentRepository.save(student1)).thenReturn(student1);
        Student student= studentService.saveOrUpadteStudent(student1);
        assertThat(student).isEqualTo(student1);
    }

    @Test
    void souldDeletedStudent() throws StudentNotFoundException {

        studentService.deleteStudent(1L);
        verify(studentRepository).deleteById(1L);

    }
}