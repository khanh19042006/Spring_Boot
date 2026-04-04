package com.example.btvn3.service;

import com.example.btvn3.dto.CreateStudentRequest;
import com.example.btvn3.dto.UpdateStudentRequest;
import com.example.btvn3.model.Student;

import java.util.List;

public interface StudentService {
    public Student create(CreateStudentRequest request);
    public List<Student> getAll();
    public boolean delete(Long id);
    public Student getById(Long id);
    public Student update(Long id, UpdateStudentRequest request);
    List<Student> getByMajor(String major);
    List<Student> getExcellentStudents();
}
