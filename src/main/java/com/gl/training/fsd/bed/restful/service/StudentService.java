package com.gl.training.fsd.bed.restful.service;

import com.gl.training.fsd.bed.restful.entity.Student;
import com.gl.training.fsd.bed.restful.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public Student getStudentById(int id) {
        Optional<Student> byId = studentRepository.findById(id);
        return byId.orElse(null);
    }

    public void update(Student student) {
        studentRepository.save(student);
    }

    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }
}
