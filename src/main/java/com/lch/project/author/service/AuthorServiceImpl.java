package com.lch.project.author.service;

import com.lch.project.author.dtos.AddAuthorDto;
import com.lch.project.author.dtos.UpdateAuthorDto;
import com.lch.project.author.mappers.AuthorMapper;
import com.lch.project.author.dtos.AuthorDto;
import com.lch.project.author.model.Author;
import com.lch.project.author.repository.AuthorRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {
    final private AuthorRepository authorRepository;
    final private AuthorMapper authorMapper;

    @Override
    public boolean authorExists(Integer id) {
        if (id == null)
            return false;

        return authorRepository.existsById(id);
    }

    @Override
    public AuthorDto getAuthor(Integer id) {
        return authorRepository
                .findById(id)
                .map(authorMapper::mapAuthorToAuthorDto).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Author getRawAuthor(Integer id) {
        return authorRepository
                .findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<AuthorDto> getAuthors() {
        return authorRepository
                .findAll().stream()
                .map(authorMapper::mapAuthorToAuthorDto)
                .collect(Collectors.toList());
    }

    @Override
    public void addAuthor(AddAuthorDto addAuthorDto) {
        Author Author = authorMapper.mapAddAuthorDtoToAuthor(addAuthorDto);
        authorRepository.save(Author);
    }

    @Override
    public boolean updateAuthor(Integer id, UpdateAuthorDto updateAuthorDto) {
        if (!authorExists(id))
            return false;

        Author Author = authorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        Author.setFirstname(updateAuthorDto.getFirstname());
        Author.setSurname(updateAuthorDto.getSurname());

        authorRepository.save(Author);
        return true;
    }

    @Override
    public boolean deleteAuthor(Integer id) {
        if (!authorExists(id))
            return false;

        authorRepository.deleteById(id);
        return true;
    }
}
