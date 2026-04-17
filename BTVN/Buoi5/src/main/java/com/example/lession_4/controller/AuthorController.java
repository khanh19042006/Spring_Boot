package com.example.lession_4.controller;

import com.example.lession_4.dto.AuthorRequest;
import com.example.lession_4.dto.response.ApiResponse;
import com.example.lession_4.dto.response.AuthorResponse;
import com.example.lession_4.dto.response.BookResponse;
import com.example.lession_4.service.AuthorService;
import com.example.lession_4.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/author")
@Validated
@RequiredArgsConstructor
public class AuthorController {

    private final BookService bookService;
    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<ApiResponse<AuthorResponse>> addAuthor(
            @RequestBody @Valid AuthorRequest authorRequest){

        AuthorResponse authorResponse = authorService.create(authorRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.created(authorResponse));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<AuthorResponse>>> findAll(Pageable pageable){

        Page<AuthorResponse> result = authorService.findAll(pageable);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.sussces(result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AuthorResponse>> findById(@PathVariable Long id){

        AuthorResponse authorResponse = authorService.findById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.sussces(authorResponse));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<AuthorResponse>> updateById(
            @PathVariable Long id,
            @RequestBody @Valid AuthorRequest authorRequest){

        AuthorResponse authorResponse = authorService.update(id, authorRequest);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.sussces(authorResponse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteById(@PathVariable Long id){

        authorService.delete(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.sussces(null));
    }

    @GetMapping("/{id}/books")
    public ResponseEntity<ApiResponse<Page<BookResponse>>> findBooksByAuthorId(
            @PathVariable Long id,
            Pageable pageable){

        Page<BookResponse> result = authorService.findBooksByAuthor(id, pageable);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.sussces(result));
    }
}
