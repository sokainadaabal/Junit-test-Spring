package com.geo.test.mappers;

import com.geo.test.entites.StudentDto;

public interface StudentMapper {
    StudentDto studentDtoToStudent(com.geo.test.dtos.StudentDto studentDto);
    com.geo.test.dtos.StudentDto studentToStudentDto(StudentDto studentDto);
}
