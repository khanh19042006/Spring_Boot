package com.example.lession_4.dto.response;

import com.example.lession_4.entity.Author;
import com.example.lession_4.entity.book.Book;
import com.example.lession_4.entity.book.Category;
import com.example.lession_4.entity.book.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class BookResponse {
    private String title;
    private String isbn;
    private Category category;
    private Status status = Status.AVAILABLE;
    private Integer totalCopies;
    private Integer availableCopies;
    private Integer publishedYear;
    private Author author;

    public static BookResponse from(Book book){
        return BookResponse.builder()
                .title(book.getTitle())
                .isbn(book.getIsbn())
                .category(book.getCategory())
                .status(book.getStatus())
                .totalCopies(book.getTotalCopies())
                .availableCopies(book.getAvailableCopies())
                .publishedYear(book.getPublishedYear())
                .author(book.getAuthor())
                .build();
    }
}
