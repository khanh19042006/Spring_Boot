package com.example.lession_4.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequest {
    @Size(min = 2, max = 10, message = "Tên phải dài 2-100 ký tự")
    private String name;

    @NotBlank
    private String email;

    @Size(min = 10, max = 10, message = "Số điện thoại cần có 10 số")
    private String phone;
}
