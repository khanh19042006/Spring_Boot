package com.example.lession_4.entity;

import com.example.lession_4.entity.book.Book;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "author")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @Size(min = 2, max = 100)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(length = 10)
    @Size(min = 10, max = 10)
    private String phone;

    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    @OneToMany(mappedBy = "author")
    private List<Book> books;

    @PrePersist
    private void onCreate(){
        this.createAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
    }

    @PreUpdate
    private void onUpdate(){
        this.updateAt = LocalDateTime.now();
    }
}
