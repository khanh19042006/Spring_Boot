package com.example.lession_4.controller;

import com.example.lession_4.dto.BookRequest;
import com.example.lession_4.dto.response.ApiResponse;
import com.example.lession_4.dto.response.BookResponse;
import com.example.lession_4.entity.book.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@Validated
public class BookController {
    @PostMapping
    public ApiResponse<BookResponse> addBook(@RequestBody BookRequest bookRequest){}

    @GetMapping
    public ApiResponse<Page<BookResponse>> findAll(Pageable pageable){}

    @GetMapping("/{id}")
    public ApiResponse<BookResponse> findById(@PathVariable Long id){}

    @PutMapping("/{id}")
    public ApiResponse<BookResponse> updateBook(@PathVariable Long id){}

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteBook(@PathVariable Long id){}

    @PostMapping("/{id}/borrow")
    public ApiResponse<BookResponse> borrowBook(@PathVariable Long id){}

    @PostMapping("/{id}/return")
    public ApiResponse<BookResponse> returnBook(@PathVariable Long id){}

    @GetMapping("/search")
    public ApiResponse<BookResponse> searchBook(@RequestParam("keyword") String keyword){}

    @GetMapping("/category/{category}")
    public ApiResponse<Page<BookResponse>> findBookByCategory(@PathVariable Category category,
                                                              Pageable pageable
    ){}
}
