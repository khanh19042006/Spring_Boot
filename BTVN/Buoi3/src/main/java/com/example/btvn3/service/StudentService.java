package com.example.btvn3.service;

import com.example.btvn3.dto.CreateStudentRequest;
import com.example.btvn3.dto.UpdateStudentRequest;
import com.example.btvn3.exception.DuplicateResourceException;
import com.example.btvn3.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final List<Student> students = new ArrayList<>();
    private Long currentId = 1L;

    // CREATE
    public Student create(CreateStudentRequest request) {
        for (Student student : students){
            if (student.getStudentCode().equalsIgnoreCase(request.getStudentCode())) throw
            new DuplicateResourceException("studentCode", student.getStudentCode().toString(), request.getStudentCode());
        }
        Student student = new Student();
        student.setId(currentId++);
        student.setStudentCode(request.getStudentCode());
        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setPhone(request.getPhone());
        student.setDateOfBirth(request.getDateOfBirth());
        student.setGpa(request.getGpa());
        student.setMajor(request.getMajor());
        student.setYear(request.getYear());

        students.add(student);
        return student;
    }

    // READ ALL
    public List<Student> getAll() {
        return students;
    }

    // UPDATE
    public Student update(Long id, UpdateStudentRequest request) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.setName(request.getName());
                student.setEmail(request.getEmail());
                student.setPhone(request.getPhone());
                student.setDateOfBirth(request.getDateOfBirth());
                student.setGpa(request.getGpa());
                student.setMajor(request.getMajor());
                student.setYear(request.getYear());
                return student;
            }
        }
        return null;
    }

    // DELETE
    public boolean delete(Long id) {
        return students.removeIf(student -> student.getId().equals(id));
    }
}
