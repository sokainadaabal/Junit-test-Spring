package com.geo.test.mappers;

import com.geo.test.entites.StudentDto;
import org.springframework.stereotype.Service;

@Service
public class StudentMapperImpl implements StudentMapper{
    @Override
    public StudentDto studentDtoToStudent(com.geo.test.dtos.StudentDto studentDto) {
        StudentDto student = new StudentDto();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
        return student;
    }

    @Override
    public com.geo.test.dtos.StudentDto studentToStudentDto(StudentDto student) {
        com.geo.test.dtos.StudentDto studentDto = new com.geo.test.dtos.StudentDto();
        studentDto.setId(student.getId());
        studentDto.setAge(student.getAge());
        studentDto.setName(student.getName());
        return studentDto;
    }
}
