package com.example.lession_4.service.Impl;

import com.example.lession_4.dto.BookRequest;
import com.example.lession_4.dto.response.BookResponse;
import com.example.lession_4.entity.book.Category;
import com.example.lession_4.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public Page<BookResponse> findAll(Pageable pageable){}

    @Override
    public BookResponse findById(Long id){}

    @Override
    public BookResponse create(BookRequest bookRequest){}

    @Override
    public BookResponse update(Long id, BookRequest bookRequest){}

    @Override
    public void delete(Long id){}

    @Override
    public BookResponse borrow(Long id){}

    @Override
    public BookResponse returnBook(Long id){}

    @Override
    public Page<BookResponse> search(String keyword, Pageable pageable){}

    @Override
    public Page<BookResponse> findByCategory(Category category, Pageable pageable){}
}
