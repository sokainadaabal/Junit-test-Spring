package com.geo.test.services;


import com.geo.test.dtos.StudentDto;
import com.geo.test.entites.Student;
import com.geo.test.mappers.StudentMapper;
import com.geo.test.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{

    private StudentMapper studentMapper;
    private StudentRepository studentRepository;
    @Override
    public StudentDto addStudent(Student student) {
        Student studentSave=studentRepository.save(student);
        return studentMapper.studentToStudentDto(studentSave);
    }

    @Override
    public StudentDto updateStudent(Student student) {
        Student studentFind= studentRepository.findById(1L).get();
        studentFind.setName(student.getName());
        studentFind.setAge(student.getAge());
        studentFind.setPassword(student.getPassword());
        Student studentSave= studentRepository.save(studentFind);
        return studentMapper.studentToStudentDto(studentSave);
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> getAllStudent=studentRepository.findAll();
        return getAllStudent.stream().map(student ->
            studentMapper.studentToStudentDto(student)).collect(Collectors.toList());
    }

    @Override
    public StudentDto serachStudent(Long id) {
        Student studentFind=studentRepository.findById(id).orElse(null);
        return studentMapper.studentToStudentDto(studentFind);
    }
}
