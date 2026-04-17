package com.example.lession_4.data;

import com.example.lession_4.entity.Author;
import com.example.lession_4.entity.book.Book;
import com.example.lession_4.entity.book.Category;
import com.example.lession_4.entity.book.Status;

import java.time.LocalDateTime;
import java.util.List;

public class Data {
    public static List<Author> authors = List.of(
            new Author(1L, "Martin", "martin@gmail.com", "0123456789", LocalDateTime.now(), LocalDateTime.now(), null),
            new Author(2L, "Joshua", "joshua@gmail.com", "0123456790", LocalDateTime.now(), LocalDateTime.now(), null),
            new Author(3L, "Rowling", "rowling@gmail.com", "0123456791", LocalDateTime.now(), LocalDateTime.now(), null),
            new Author(4L, "Tolkien", "tolkien@gmail.com", "0123456792", LocalDateTime.now(), LocalDateTime.now(), null),
            new Author(5L, "Morgan", "morgan@gmail.com", "0123456793", LocalDateTime.now(), LocalDateTime.now(), null)
    );

    public static List<Book> books = List.of(
            new Book(1L, "Clean Code", "ISBN001", Category.HISTORY, Status.AVAILABLE, 10, 8, 2008, authors.get(0), LocalDateTime.now(), LocalDateTime.now()),
            new Book(2L, "Effective Java", "ISBN002", Category.ECONOMICS, Status.AVAILABLE, 12, 10, 2018, authors.get(1), LocalDateTime.now(), LocalDateTime.now()),
            new Book(3L, "Harry Potter", "ISBN003", Category.LITERATURE, Status.DISCONTINUED, 15, 15, 1997, authors.get(2), LocalDateTime.now(), LocalDateTime.now()),
            new Book(4L, "The Hobbit", "ISBN004", Category.SCIENCE, Status.AVAILABLE, 9, 5, 1937, authors.get(3), LocalDateTime.now(), LocalDateTime.now()),
            new Book(5L, "The Psychology of Money", "ISBN005", Category.PROGRAMMING, Status.OUT_OF_STOCK, 14, 11, 2020, authors.get(4), LocalDateTime.now(), LocalDateTime.now())
    );
}
