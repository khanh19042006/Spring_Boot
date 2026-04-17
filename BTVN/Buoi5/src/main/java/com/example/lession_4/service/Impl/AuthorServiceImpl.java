package com.example.lession_4.service.Impl;

import com.example.lession_4.dto.AuthorRequest;
import com.example.lession_4.dto.response.AuthorResponse;
import com.example.lession_4.dto.response.BookResponse;
import com.example.lession_4.entity.Author;
import com.example.lession_4.entity.book.Book;
import com.example.lession_4.exception.BadRequestException;
import com.example.lession_4.exception.DuplicateResourceException;
import com.example.lession_4.exception.ResourceNotFoundException;
import com.example.lession_4.repository.AuthorRepository;
import com.example.lession_4.repository.BookRepository;
import com.example.lession_4.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<AuthorResponse> findAll(Pageable pageable){
        return authorRepository.findAll(pageable).map(AuthorResponse::from);
    }

    @Override
    @Transactional(readOnly = true)
    public AuthorResponse findById(Long id){
        return authorRepository.findById(id)
                .map(AuthorResponse::from)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

    @Override
    @Transactional
    public AuthorResponse create(AuthorRequest authorRequest){
        if (authorRepository.existsByEmail(authorRequest.getEmail()))
            throw new DuplicateResourceException("Author", "email", authorRequest.getEmail());

        Author author = Author.builder()
                .name(authorRequest.getName())
                .email(authorRequest.getEmail())
                .phone(authorRequest.getPhone())
                .build();
        return AuthorResponse.from(authorRepository.save(author));
    }

    @Override
    @Transactional
    public AuthorResponse update(Long id, AuthorRequest authorRequest){
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));

        author.setName(authorRequest.getName());
        author.setEmail(authorRequest.getEmail());
        author.setPhone(authorRequest.getPhone());

        // Không cần save() — JPA Dirty Checking sẽ tự update
        return AuthorResponse.from(author);
    }

    @Override
    @Transactional
    public void delete(Long id){
        if (!authorRepository.existsById(id))
            throw new ResourceNotFoundException("Author", "id", id);

        Page<Book> books = bookRepository.findBookByAuthorId(id, PageRequest.of(0,1));
        if (books.isEmpty())
            throw new BadRequestException("AuthorId", id);

        authorRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BookResponse> findBooksByAuthor(Long id, Pageable pageable){
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));

        return bookRepository.findBookByAuthorId(author.getId(), pageable).map(BookResponse::from);
    }
}
