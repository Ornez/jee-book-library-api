package com.lch.project.book.service;

import com.lch.project.book.converters.BookMapper;
import com.lch.project.book.dtos.AuthorDto;
import com.lch.project.book.model.Author;
import com.lch.project.book.repository.AuthorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {
    final private AuthorRepository authorRepository;
    @Autowired
    final private BookMapper bookMapper;

    @Override
    public boolean authorExists(Integer authorId) {
        return authorRepository.existsById(authorId);
    }

    @Override
    public AuthorDto getAuthor(Integer AuthorId) {
        return authorRepository
                .findById(AuthorId)
                .map(bookMapper::mapAuthorToAuthorDto).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Author getRawAuthor(Integer AuthorId) {
        return authorRepository
                .findById(AuthorId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<AuthorDto> getAuthors() {
        return authorRepository
                .findAll().stream()
                .map(bookMapper::mapAuthorToAuthorDto)
                .collect(Collectors.toList());
    }

    @Override
    public void addAuthor(AuthorDto AuthorDto) {
        Author Author = bookMapper.mapAuthorDtoToAuthor(AuthorDto);
        authorRepository.save(Author);
    }

    @Override
    public boolean updateAuthor(AuthorDto AuthorDto) {
        if (!authorExists(AuthorDto.getId()))
            return false;

        Author Author = authorRepository.findById(AuthorDto.getId()).orElseThrow(EntityNotFoundException::new);
        Author.setFirstname(AuthorDto.getFirstname());
        Author.setSurname(AuthorDto.getSurname());

        authorRepository.save(Author);
        return true;
    }

    @Override
    public void deleteAuthor(Integer AuthorId) {
        authorRepository.deleteById(AuthorId);
    }

}
