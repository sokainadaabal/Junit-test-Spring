package com.geo.test.services;


import com.geo.test.entites.StudentDto;
import com.geo.test.mappers.StudentMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{
    StudentDto studentDto;
    StudentMapper studentMapper;
    @Override
    public StudentDto addStudent(StudentDto studentDto) {
        return null;
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto) {
        return null;
    }

    @Override
    public List<StudentDto> getAllStudent() {
        return List.of();
    }

    @Override
    public StudentDto serachStudent(Long id) {
        return null;
    }
}
