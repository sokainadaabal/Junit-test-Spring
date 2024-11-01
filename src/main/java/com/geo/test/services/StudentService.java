package com.geo.test.services;

import com.geo.test.dtos.StudentDto;
import com.geo.test.entites.Student;
import com.geo.test.exceptions.StudentNotFoundException;

import java.util.List;

public interface StudentService {
    StudentDto addStudent(Student student);
    StudentDto updateStudent(Student student);
    List<StudentDto> getAllStudent();
    StudentDto serachStudent(Long id) throws StudentNotFoundException;
    Student saveOrUpadteStudent(Student student);
    void deleteStudent(Long id) throws StudentNotFoundException;
}
