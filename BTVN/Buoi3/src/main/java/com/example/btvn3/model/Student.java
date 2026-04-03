package com.example.btvn3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    private Long id;
    private String studentCode;
    private String name;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;
    private Double gpa;
    private String major;
    private Integer year;
}
