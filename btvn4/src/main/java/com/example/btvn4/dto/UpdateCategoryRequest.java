package com.example.btvn4.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateCategoryRequest {

    @NotBlank(message = "Tên không được để trống")
    private String name;

    @Size(max = 500, message = "Mô tả không quá 500 ký tự")
    private String description;
}
