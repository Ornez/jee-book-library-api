package com.lch.project.book.service;

import com.lch.project.book.dtos.AuthorDto;
import com.lch.project.book.model.Author;

import java.util.List;

public interface AuthorService {
    boolean authorExists(Integer authorId);
    Author getRawAuthor(Integer AuthorId);
    AuthorDto getAuthor(Integer authorId);
    List<AuthorDto> getAuthors();
    void addAuthor(AuthorDto authorDto);
    boolean updateAuthor(AuthorDto authorDto);
    void deleteAuthor(Integer authorId);
}
