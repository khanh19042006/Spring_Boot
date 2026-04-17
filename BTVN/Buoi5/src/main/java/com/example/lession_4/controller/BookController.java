package com.example.lession_4.controller;

import com.example.lession_4.dto.BookRequest;
import com.example.lession_4.dto.response.ApiResponse;
import com.example.lession_4.dto.response.BookResponse;
import com.example.lession_4.entity.book.Book;
import com.example.lession_4.entity.book.Category;
import com.example.lession_4.service.AuthorService;
import com.example.lession_4.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@Validated
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<ApiResponse<BookResponse>> addBook(@RequestBody BookRequest bookRequest){
        BookResponse bookResponse = bookService.create(bookRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.created(bookResponse));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<BookResponse>>> findAll(@RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int size){

        Page<BookResponse> bookResponsePage = bookService.findAll(PageRequest.of(page, size));
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.sussces(bookResponsePage));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BookResponse>> findById(@PathVariable Long id){
        BookResponse bookResponse = bookService.findById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.sussces(bookResponse));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<BookResponse>> updateBook(
            @PathVariable Long id,
            @RequestBody BookRequest bookRequest){

        BookResponse bookResponse = bookService.update(id, bookRequest);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.sussces(bookResponse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteBook(@PathVariable Long id){
        bookService.delete(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.sussces(null));
    }

    @PostMapping("/{id}/borrow")
    public ResponseEntity<ApiResponse<BookResponse>> borrowBook(@PathVariable Long id){
        BookResponse bookResponse = bookService.borrow(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.sussces(bookResponse));
    }

    @PostMapping("/{id}/return")
    public ResponseEntity<ApiResponse<BookResponse>> returnBook(@PathVariable Long id){
        BookResponse bookResponse = bookService.returnBook(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.sussces(bookResponse));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<Page<BookResponse>>> searchBook(
            @RequestParam("keyword") String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){

        Page<BookResponse> result = bookService.search(keyword, PageRequest.of(page, size));

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.sussces(result));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<ApiResponse<Page<BookResponse>>> findBookByCategory(
            @PathVariable Category category,
            Pageable pageable){

        Page<BookResponse> result = bookService.findByCategory(category, pageable);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.sussces(result));
    }
}
