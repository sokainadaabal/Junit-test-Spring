package com.geo.test.services;


import com.geo.test.dtos.StudentDto;
import com.geo.test.entites.Student;
import com.geo.test.mappers.StudentMapper;
import com.geo.test.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{

    StudentMapper studentMapper;
    StudentRepository studentRepository;
    @Override
    public StudentDto addStudent(Student student) {
        Student studentSave=studentRepository.save(student);
        return studentMapper.studentToStudentDto(studentSave);
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto) {
        return null;
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> getAllStudent=studentRepository.findAll();
        return getAllStudent.stream().map(student ->
            studentMapper.studentToStudentDto(student)).collect(Collectors.toList());
    }

    @Override
    public StudentDto serachStudent(Long id) {
        return null;
    }
}
