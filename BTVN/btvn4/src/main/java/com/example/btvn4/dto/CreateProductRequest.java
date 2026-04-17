package com.example.btvn4.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Dữ liệu để tạo 1 sản phẩm mới")
public class CreateProductRequest {
    @NotBlank(message = "Tên không được để trống")
    @Size(min = 2, max = 100, message = "Tên chỉ được có 2-100 ký tự")
    @Schema(description = "Tên đầy đủ của sản phẩm", example = "Diana")
    private String name;

    @Positive(message = "Giá phải lớn hơn 0")
    @Schema(description = "Giá của sản phẩm", example = "99 VND")
    private Double price;

    @PositiveOrZero(message = "Số lượng phải lớn hơn hoặc bằng 0")
    @Schema(description = "Số lượng của sản phẩm", example = "0")
    private Integer quantity;

    @Size(max = 1000, message = "Mô tả không được quá 1000 ký tự")
    @NotBlank(message = "Mô tả không được bỏ trống")
    @Schema(description = "Mô tả về sản phẩm", example = "Đây là con tướng cực mạnh trong tay cao thủ")
    private String description;
}
