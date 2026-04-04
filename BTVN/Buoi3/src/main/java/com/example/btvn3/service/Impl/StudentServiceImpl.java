package com.example.btvn3.service.Impl;

import com.example.btvn3.dto.CreateStudentRequest;
import com.example.btvn3.dto.UpdateStudentRequest;
import com.example.btvn3.exception.DuplicateResourceException;
import com.example.btvn3.exception.ResourceNotFoundException;
import com.example.btvn3.model.Student;
import com.example.btvn3.service.StudentService;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private final List<Student> students = new ArrayList<>();
    private Long currentId = 1L;

    @Override
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

    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
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
        throw new ResourceNotFoundException("id", "StudentId", getById(id).toString());
    }

    @Override
    public boolean delete(Long id) {
        if (students.removeIf(student -> student.getId().equals(id))) return true;
        throw new ResourceNotFoundException("id", "StudentId", getById(id).toString());
    }

    @Override
    public Student getById(Long id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> getByMajor(String major) {
        List<Student> result = new ArrayList<>();

        for (Student student : students) {
            if (student.getMajor() != null &&
                    student.getMajor().equalsIgnoreCase(major)) {
                result.add(student);
            }
        }

        return result;
    }

    @Override
    public List<Student> getExcellentStudents() {
        List<Student> result = new ArrayList<>();

        for (Student student : students) {
            if (student.getGpa() >= 3.6) {
                result.add(student);
            }
        }

        return result;
    }
}
