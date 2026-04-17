package com.example.lession_4.dto.response;

import com.example.lession_4.entity.Author;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthorResponse {
    private Long id;
    private String name;
    private String email;
    private String phone;

    public static AuthorResponse from(Author author){
        return AuthorResponse.builder()
                .id(author.getId())
                .name(author.getName())
                .email(author.getEmail())
                .phone(author.getPhone())
                .build();
    }
}
