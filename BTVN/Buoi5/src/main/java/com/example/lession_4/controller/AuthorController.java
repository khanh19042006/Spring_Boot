package com.example.lession_4.controller;

import com.example.lession_4.dto.AuthorRequest;
import com.example.lession_4.dto.response.ApiResponse;
import com.example.lession_4.dto.response.AuthorResponse;
import com.example.lession_4.dto.response.BookResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/author")
@Validated
public class AuthorController {
    @PostMapping
    public ApiResponse<AuthorResponse> addAuthor(@RequestBody AuthorRequest authorRequest){}

    @GetMapping
    public ApiResponse<Page<BookResponse>> findAll(Pageable pageable){}

    @GetMapping("/{id}")
    public ApiResponse<AuthorResponse> findById(@PathVariable Long id){}

    @PutMapping("/{id}")
    public ApiResponse<AuthorResponse> updateById(@PathVariable Long id,
                                                  @RequestBody @Valid AuthorRequest authorRequest
    ){}

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteById(@PathVariable Long id){}

    @GetMapping("/{id}/books")
    public ApiResponse<Page<BookResponse>> findBooksByAuthorId(@PathVariable Long id,
                                                               Pageable pageable
    ){}
}
