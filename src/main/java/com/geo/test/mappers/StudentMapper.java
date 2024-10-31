package com.geo.test.mappers;

import com.geo.test.dtos.StudentDto;
import com.geo.test.entites.Student;

public interface StudentMapper {
    Student studentDtoToStudent(StudentDto studentDto);
    StudentDto studentToStudentDto(Student student);
}
