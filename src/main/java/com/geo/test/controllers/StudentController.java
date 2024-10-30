package com.geo.test.controllers;


import com.geo.test.entites.StudentDto;
import com.geo.test.services.StudentService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping
public class StudentController {
    StudentService studentService;

    public StudentController(StudentService studentService){
        studentService=this.studentService;
    }

    @GetMapping("/getAllUser")
    public List<StudentDto> getAllStudent(){
        return studentService.getAllStudent();
    }

    @PostMapping("/addStudent")
    public StudentDto addStudent(@RequestBody StudentDto studentDto)
    {
        return studentService.addStudent(studentDto);
    }

}
