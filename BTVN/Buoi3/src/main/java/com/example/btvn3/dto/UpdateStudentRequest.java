package com.example.btvn3.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateStudentRequest {

    private Long id;

    @NotBlank(message = "Tên không được để trống")
    private String name;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    private String email;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(
            regexp = "^(0|\\+84)(3|5|7|8|9)\\d{8}$",
            message = "Số điện thoại không hợp lệ"
    )
    private String phone;

    @NotNull(message = "Ngày sinh không được để trống")
    @Past(message = "Ngày sinh phải là ngày trong quá khứ")
    private LocalDate dateOfBirth;

    @NotNull(message = "GPA không được để trống")
    @DecimalMin(value = "0.0", message = "GPA phải >= 0")
    @DecimalMax(value = "4.0", message = "GPA phải <= 4")
    private Double gpa;

    @NotBlank(message = "Ngành học không được để trống")
    private String major;

    @NotNull(message = "Năm học không được để trống")
    @Min(value = 1, message = "Năm học tối thiểu là 1")
    @Max(value = 6, message = "Năm học tối đa là 6")
    private Integer year;
}