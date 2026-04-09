package com.example.btvn4.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateProductRequest {
    @NotBlank(message = "Tên không được để trống")
    @Size(min = 2, max = 100, message = "Tên chỉ được có 2-100 ký tự")
    private String name;

    @Positive(message = "Giá phải lớn hơn 0")
    private Double price;

    @PositiveOrZero(message = "Số lượng phải lớn hơn hoặc bằng 0")
    private Integer quantity;

    @Size(max = 1000, message = "Mô tả không được quá 1000 ký tự")
    @NotBlank(message = "Mô tả không được bỏ trống")
    private String description;

    private Boolean active = true;
}
