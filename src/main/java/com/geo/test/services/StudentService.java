package com.geo.test.services;

import com.geo.test.dtos.StudentDto;
import com.geo.test.entites.Student;

import java.util.List;

public interface StudentService {
    StudentDto addStudent(Student student);
    StudentDto updateStudent(Student student);
    List<StudentDto> getAllStudent();
    StudentDto serachStudent(Long id);
}
