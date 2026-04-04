package com.example.btvn3.controller;

import com.example.btvn3.dto.CreateStudentRequest;
import com.example.btvn3.dto.UpdateStudentRequest;
import com.example.btvn3.dto.respone.ApiResponse;
import com.example.btvn3.model.Student;
import com.example.btvn3.service.Impl.StudentServiceImpl;
import com.example.btvn3.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudent(){
        List<Student> students = studentService.getAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.sussces(students));
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<Student>> getById(@PathVariable Long id){
        Student student = studentService.getById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.sussces(student));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<?>> created(@Valid @RequestBody CreateStudentRequest createStudentRequest){
        Student student = studentService.create(createStudentRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.created(student));
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponse<?>> updated(@PathVariable Long id, @Valid @RequestBody UpdateStudentRequest updateStudentRequest){
        Student student = studentService.update(id, updateStudentRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.sussces(student));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<?>> delete(@PathVariable Long id){
        boolean isSussces = studentService.delete(id);
        if (isSussces) return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.sussces(isSussces));
        else return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error(500, "Xóa thất bại"));
    }

    @GetMapping("/major/{major}")
    public ResponseEntity<ApiResponse<?>> getByMajor(@PathVariable String major){
        List<Student> students = studentService.getByMajor(major);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.sussces(students));
    }

    @GetMapping("/honors")
    public ResponseEntity<ApiResponse<?>> getStudentHonors(){
        List<Student> students = studentService.getExcellentStudents();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.sussces(students));
    }
}
