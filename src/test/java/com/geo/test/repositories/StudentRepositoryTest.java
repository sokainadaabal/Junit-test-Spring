package com.geo.test.repositories;

import com.geo.test.entites.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void getAllStudent()
    {
        // la regle de trois a : arrange , act , assert

        // arrange : remplire base de donnees
        // act : appel de fucntion
        List<Student> allStudent=studentRepository.findAll();

        // assert : les verifications
        assertEquals(2,allStudent.size());
        assertEquals("sokaina",allStudent.get(0).getName());
    }

    @Test
    void getStudentById(){
        Student searchStudent=studentRepository.findById(1L).get();

        assertEquals(1,searchStudent.getId());
        assertEquals(15,searchStudent.getAge());
        assertEquals("sokaina",searchStudent.getName());
    }


    @Test
    void saveStudent(){
        Student student = new Student();
        student.setAge(24L);
        student.setName("daabal");
        student.setPassword("rachida@18");

        Student saveStudent=studentRepository.save(student);
        assertNotNull(saveStudent.getId());

        assertEquals(24,saveStudent.getAge());
        assertEquals("daabal",saveStudent.getName());
    }


    @Test
    void updateStudent(){
        Student student=studentRepository.findById(2L).get();
        student.setName("Mohammed");
        Student updateStudent=studentRepository.save(student);
        assertNotNull(updateStudent.getId());
        assertEquals(2L,updateStudent.getId());
        assertEquals("Mohammed",updateStudent.getName());
    }


    @Test
    void deleteStudent(){
        studentRepository.deleteById(1L);
        Optional<Student> studentSearch=studentRepository.findById(1L);
        assertFalse(studentSearch.isPresent());
    }
}