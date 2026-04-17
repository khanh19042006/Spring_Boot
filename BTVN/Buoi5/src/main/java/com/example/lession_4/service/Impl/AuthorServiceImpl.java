package com.example.lession_4.service.Impl;

import com.example.lession_4.dto.AuthorRequest;
import com.example.lession_4.dto.response.AuthorResponse;
import com.example.lession_4.dto.response.BookResponse;
import com.example.lession_4.service.AuthorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Override
    public Page<AuthorResponse> findAll(Pageable pageable){}

    @Override
    public AuthorResponse findById(Long id){}

    @Override
    public AuthorResponse create(AuthorRequest authorRequest){}

    @Override
    public AuthorResponse update(Long id, AuthorRequest authorRequest){}

    @Override
    public void delete(Long id){}

    @Override
    public Page<BookResponse> findBooksByAuthor(Long id, Pageable pageable){}
}
