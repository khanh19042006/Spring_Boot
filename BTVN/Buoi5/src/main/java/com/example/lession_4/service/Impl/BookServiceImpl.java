package com.example.lession_4.service.Impl;

import com.example.lession_4.dto.BookRequest;
import com.example.lession_4.dto.response.BookResponse;
import com.example.lession_4.entity.book.Book;
import com.example.lession_4.entity.book.Category;
import com.example.lession_4.entity.book.Status;
import com.example.lession_4.exception.BadRequestException;
import com.example.lession_4.exception.DuplicateResourceException;
import com.example.lession_4.exception.ResourceNotFoundException;
import com.example.lession_4.repository.AuthorRepository;
import com.example.lession_4.repository.BookRepository;
import com.example.lession_4.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<BookResponse> findAll(Pageable pageable){
        return bookRepository.findAll(pageable)
                .map(BookResponse::from);
    }

    @Override
    @Transactional(readOnly = true)
    public BookResponse findById(Long id){
        return bookRepository.findById(id)
                .map(BookResponse::from)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
    }

    @Override
    @Transactional
    public BookResponse create(BookRequest bookRequest){
        if (!authorRepository.existsById(bookRequest.getAuthor().getId()))
            throw new ResourceNotFoundException("Author", "id", bookRequest.getAuthor().getId());

        if (bookRepository.existsByIsbn(bookRequest.getIsbn()))
            throw new DuplicateResourceException("Book", "isbn", bookRequest.getIsbn());

        Book book = Book.builder()
                .title(bookRequest.getTitle())
                .isbn(bookRequest.getIsbn())
                .category(bookRequest.getCategory())
                .publishedYear(bookRequest.getPublishedYear())
                .totalCopies(bookRequest.getTotalCopies())
                .availableCopies(bookRequest.getTotalCopies())
                .author(authorRepository.findById(bookRequest.getAuthor().getId()).get())
                .build();

        return BookResponse.from(bookRepository.save(book));
    }

    @Override
    @Transactional
    public BookResponse update(Long id, BookRequest bookRequest){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));

        book.setTitle(bookRequest.getTitle());
        book.setIsbn(bookRequest.getIsbn());
        book.setCategory(bookRequest.getCategory());
        book.setPublishedYear(bookRequest.getPublishedYear());
        book.setTotalCopies(bookRequest.getTotalCopies());

        return BookResponse.from(book);
    }

    @Override
    @Transactional
    public void delete(Long id){
        if (!bookRepository.existsById(id))
            throw new ResourceNotFoundException("Book", "id", id);

        Book book = bookRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
        if (book.getAvailableCopies() < book.getTotalCopies())
            throw new BadRequestException("Sách đang có người mượn");

        bookRepository.deleteById(id);
    }

    @Override
    @Transactional
    public BookResponse borrow(Long id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));

        if (book.getStatus().equals(Status.DISCONTINUED))
            throw new BadRequestException("Sách đã ngừng phát hành");

        if (book.getAvailableCopies() <= 0)
            throw new IllegalStateException("Sách hiện tại đã hết");

        book.setAvailableCopies(book.getAvailableCopies() - 1);

        if (book.getAvailableCopies() == 0)
            book.setStatus(Status.OUT_OF_STOCK);

        return BookResponse.from(book);
    }

    @Override
    @Transactional
    public BookResponse returnBook(Long id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));

        if (book.getAvailableCopies() == book.getTotalCopies())
            throw new IllegalStateException("Sách đã đủ, không thể trả thêm");

        book.setAvailableCopies(book.getAvailableCopies() + 1);

        if (book.getStatus().equals(Status.OUT_OF_STOCK))
            book.setStatus(Status.AVAILABLE);

        return BookResponse.from(book);
    }

    @Override
    public Page<BookResponse> search(String keyword, Pageable pageable){
        return bookRepository.findByTitleContainingIgnoreCase(keyword, pageable)
                .map(BookResponse::from);
    }

    @Override
    public Page<BookResponse> findByCategory(Category category, Pageable pageable){
        return bookRepository.findByCategory(category, pageable)
                .map(BookResponse::from);
    }
}
