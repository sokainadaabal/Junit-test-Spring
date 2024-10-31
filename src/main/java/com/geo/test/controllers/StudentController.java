package com.geo.test.controllers;


import com.geo.test.dtos.StudentDto;
import com.geo.test.entites.Student;
import com.geo.test.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping

public class StudentController {
    private  final StudentService studentService;

    public StudentController(StudentService studentService){
       this.studentService=studentService;
    }

    @GetMapping("/getAllUser")
    public List<StudentDto> getAllStudent(){
        return studentService.getAllStudent();
    }

    @PostMapping("/addStudent")
    public StudentDto addStudent(@RequestBody Student student)
    {
        return studentService.addStudent(student);
    }

}
