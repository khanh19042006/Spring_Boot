package com.example.lession_4.service;

import com.example.lession_4.dto.BookRequest;
import com.example.lession_4.dto.response.BookResponse;
import com.example.lession_4.entity.book.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    public Page<BookResponse> findAll(Pageable pageable);
    public BookResponse findById(Long id);
    public BookResponse create(BookRequest bookRequest);
    public BookResponse update(Long id, BookRequest bookRequest);
    public void delete(Long id);
    public BookResponse borrow(Long id);
    public BookResponse returnBook(Long id);
    public Page<BookResponse> search(String keyword, Pageable pageable);
    public Page<BookResponse> findByCategory(Category category, Pageable pageable);
}
