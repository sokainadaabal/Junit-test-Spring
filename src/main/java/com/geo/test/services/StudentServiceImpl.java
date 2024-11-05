package com.geo.test.services;


import com.geo.test.dtos.StudentDto;
import com.geo.test.entites.Student;
import com.geo.test.exceptions.StudentNotFoundException;
import com.geo.test.mappers.StudentMapper;
import com.geo.test.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
        Student studentFind= studentRepository.findById(student.getId()).orElse(null);
        if(Objects.nonNull(studentFind)){
            studentFind.setId(student.getId());
            studentFind.setName(student.getName());
            studentFind.setAge(student.getAge());
            studentFind.setPassword(student.getPassword());
            Student studentSave= studentRepository.save(studentFind);
            return studentMapper.studentToStudentDto(studentSave);
        }
        else return null;

    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> getAllStudent=studentRepository.findAll();
        return getAllStudent.stream().map(student ->
            studentMapper.studentToStudentDto(student)).collect(Collectors.toList());
    }

    @Override
    public StudentDto searchStudent(Long id) throws StudentNotFoundException {
        Student studentFind=studentRepository.findById(id).orElse(null);
        if(Objects.isNull(studentFind)){
            throw new StudentNotFoundException("Student with id " + id + "Not Exist in data base");

        }
        return studentMapper.studentToStudentDto(studentFind);
    }

    @Override
    public Student saveOrUpadteStudent(Student student) {
        Student findStudent=studentRepository.findById(student.getId()).orElse(null);

        if(findStudent==null){
            return studentRepository.save(student);
        }
        else {
            findStudent.setName(student.getName());
            findStudent.setAge(student.getAge());
            findStudent.setPassword(student.getPassword());
            return studentRepository.save(findStudent);
        }
    }

    @Override
    public void deleteStudent(Long id){
          studentRepository.deleteById(id);
    }
}
