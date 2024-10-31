package com.geo.test.mappers;

import com.geo.test.dtos.StudentDto;
import com.geo.test.entites.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapperImpl implements StudentMapper{
    @Override
    public Student studentDtoToStudent(com.geo.test.dtos.StudentDto studentDto) {
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
        return student;
    }

    @Override
    public StudentDto studentToStudentDto(Student student) {
        com.geo.test.dtos.StudentDto studentDto = new com.geo.test.dtos.StudentDto();
        studentDto.setId(student.getId());
        studentDto.setAge(student.getAge());
        studentDto.setName(student.getName());
        return studentDto;
    }
}
