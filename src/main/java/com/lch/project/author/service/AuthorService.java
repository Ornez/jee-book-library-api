package com.lch.project.author.service;

import com.lch.project.author.dtos.AddAuthorDto;
import com.lch.project.author.dtos.AuthorDto;
import com.lch.project.author.dtos.UpdateAuthorDto;
import com.lch.project.author.model.Author;

import java.util.List;

public interface AuthorService {
    boolean authorExists(Integer id);
    Author getRawAuthor(Integer id);
    AuthorDto getAuthor(Integer id);
    List<AuthorDto> getAuthors();
    void addAuthor(AddAuthorDto addAuthorDto);
    boolean updateAuthor(Integer id, UpdateAuthorDto updateAuthorDto);
    boolean deleteAuthor(Integer id);
}
