package com.geo.test.services;

import com.geo.test.entites.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto addStudent(StudentDto studentDto);
    StudentDto updateStudent(StudentDto studentDto);
    List<StudentDto> getAllStudent();
    StudentDto serachStudent(Long id);
}
