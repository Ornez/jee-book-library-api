package com.lch.project.book.controller;

import com.lch.project.book.dtos.AuthorDto;
import com.lch.project.book.service.AuthorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorServiceImpl authorService;

    @GetMapping(value = "/author/{id}")
    public AuthorDto getAuthor(@PathVariable("id") Integer authorId) {
        return authorService.getAuthor(authorId);
    }

    @GetMapping(value = "/authors")
    public List<AuthorDto> getAuthors() {
        return authorService.getAuthors();
    }

    @PostMapping(value = "/author")
    public void addAuthor(@RequestBody AuthorDto authorDto) {
        authorService.addAuthor(authorDto);
    }

    @PutMapping("/author")
    public boolean editAuthor(@RequestBody AuthorDto authorDto) {
        return authorService.updateAuthor(authorDto);
    }

    @DeleteMapping("/author/{id}")
    public boolean deleteAuthor(@PathVariable("id") Integer authorId) {
        if (!authorService.authorExists(authorId))
            return false;

        authorService.deleteAuthor(authorId);
        return true;
    }
}
