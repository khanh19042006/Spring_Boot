package com.example.lession_4.service;

import com.example.lession_4.dto.AuthorRequest;
import com.example.lession_4.dto.response.AuthorResponse;
import com.example.lession_4.dto.response.BookResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuthorService {
    public Page<AuthorResponse> findAll(Pageable pageable);
    public AuthorResponse findById(Long id);
    public AuthorResponse create(AuthorRequest authorRequest);
    public AuthorResponse update(Long id, AuthorRequest authorRequest);
    public void delete(Long id);
    public Page<BookResponse> findBooksByAuthor(Long id, Pageable pageable);
}
