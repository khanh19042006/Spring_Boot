package com.example.lession_4.dto;

import com.example.lession_4.entity.Author;
import com.example.lession_4.entity.book.Category;
import com.example.lession_4.entity.book.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    @Size(min = 2, max = 200, message = "Tiêu đề phải có 2-200 ký tự")
    @NotBlank(message = "Tiêu đề không để trống")
    private String title;

    @NotBlank(message = "Không được để trống")
    private String isbn;

    @NotBlank(message = "Thể loại không được để trống")
    private Category category;

    @NotBlank(message = "Trạng thái không được để trống")
    private Status status = Status.AVAILABLE;

    @NotBlank
    @Min(value = 1, message = "Phải lớn hơn 1")
    private Integer totalCopies;

    @NotBlank
    @PositiveOrZero(message = "Phải lớn hơn hoặc bằng 0")
    private Integer availableCopies;

    private Integer publishedYear;

    @NotBlank
    private Author author;
}
