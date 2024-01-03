package com.lch.project.author.controller;

import com.lch.project.author.dtos.AddAuthorDto;
import com.lch.project.author.dtos.AuthorDto;
import com.lch.project.author.dtos.UpdateAuthorDto;
import com.lch.project.author.model.Author;
import com.lch.project.author.service.AuthorService;
import com.lch.project.book.dtos.UpdateBookDto;
import com.lch.project.book.model.Book;
import com.lch.project.book.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;
    private final BookService bookService;

    @PostMapping(value = "/authors")
    public void addAuthor(@RequestBody AddAuthorDto addAuthorDto) {
        authorService.addAuthor(addAuthorDto);
    }

    @GetMapping(value = "/authors")
    public List<AuthorDto> getAuthors() {
        return authorService.getAuthors();
    }
    @GetMapping(value = "/authors/{id}")
    public AuthorDto getAuthor(@PathVariable("id") Integer id) {
        return authorService.getAuthor(id);
    }

    @PutMapping("/authors/{id}")
    public boolean editAuthor(@PathVariable("id") Integer id, @RequestBody UpdateAuthorDto updateAuthorDto) {
        return authorService.updateAuthor(id, updateAuthorDto);
    }

    @DeleteMapping("/authors/{id}")
    public boolean deleteAuthor(@PathVariable("id") Integer id) {
        Author author = authorService.getRawAuthor(id);

        List<Book> books = bookService.getBooksWithAuthor(author);
        books.forEach(book -> {
            UpdateBookDto updateBookDto = new UpdateBookDto(book.getName(), book.getDescription(), book.getPages(), null);
            bookService.updateBook(book.getId(), updateBookDto);
        });

        return authorService.deleteAuthor(id);
    }
}
