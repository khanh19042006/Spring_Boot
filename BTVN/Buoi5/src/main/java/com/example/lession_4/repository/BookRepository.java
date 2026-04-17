package com.example.lession_4.repository;

import com.example.lession_4.entity.book.Book;
import com.example.lession_4.entity.book.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    public Page<Book> findBookByAuthorId(Long authorId, Pageable pageable);
    Page<Book> findByTitleContainingIgnoreCase(String keyword, Pageable pageable);
    Page<Book> findByCategory(Category category, Pageable pageable);
    public boolean existsByIsbn(String isbn);
}
