package com.lch.project.author.utils;

import com.lch.project.author.dtos.AuthorDto;
import com.lch.project.author.model.Author;

public class AuthorUtils {
    public static AuthorDto asDto(Author author) {
        return AuthorDto.builder()
                .id(author.getId())
                .firstname(author.getFirstname())
                .surname(author.getSurname())
                .build();
    }
}
