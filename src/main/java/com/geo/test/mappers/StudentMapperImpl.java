package com.geo.test.mappers;

import com.geo.test.dtos.StudentDto;
import com.geo.test.entites.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapperImpl implements StudentMapper{
    @Override
    public Student studentDtoToStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
        return student;
    }

    @Override
    public StudentDto studentToStudentDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(studentDto.getName());
        studentDto.setAge(studentDto.getAge());
        return studentDto;
    }
}
