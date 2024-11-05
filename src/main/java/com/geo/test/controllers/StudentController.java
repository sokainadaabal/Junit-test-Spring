package com.geo.test.controllers;


import com.geo.test.dtos.StudentDto;
import com.geo.test.entites.Student;
import com.geo.test.exceptions.StudentNotFoundException;
import com.geo.test.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping

public class StudentController {
    private  final StudentService studentService;

    public StudentController(StudentService studentService){
       this.studentService=studentService;
    }

    @GetMapping("/getAllStudent")
    public List<StudentDto> getAllStudent(){
        return studentService.getAllStudent();
    }

    @PostMapping("/addStudent")
    public StudentDto addStudent(@RequestBody Student student)
    {
        return studentService.addStudent(student);
    }

    @GetMapping("/id/{id}")
    public StudentDto returnStudentById(@PathVariable Long id) throws StudentNotFoundException {
        return  studentService.searchStudent(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {


            // No need to check for null if an exception is thrown when not found
            Student studentToUpdate = new Student(id, student.getName(), student.getAge(), student.getPassword());

            // Return the updated student in the response body if present
            return ResponseEntity.of(Optional.ofNullable(studentService.saveOrUpadteStudent(studentToUpdate)));


    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        try {
            StudentDto student1 = studentService.searchStudent(id);
            if (Objects.nonNull(student1)) {
                studentService.deleteStudent(id);
                return ResponseEntity.ok().build();
            }
        } catch (StudentNotFoundException e) {
            // You might consider logging this exception or handling it globally via @ControllerAdvice
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
