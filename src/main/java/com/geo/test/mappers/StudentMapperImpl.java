package com.geo.test.mappers;

import com.geo.test.dtos.StudentDto;
import com.geo.test.entites.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapperImpl implements StudentMapper{
    @Override
    public Student studentDtoToStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setId(studentDto.id());
        student.setName(studentDto.name());
        student.setAge(studentDto.age());
        return student;
    }

    @Override
    public StudentDto studentToStudentDto(Student student) {
        return new StudentDto(student.getId(), student.getName(), student.getAge());
    }
}
