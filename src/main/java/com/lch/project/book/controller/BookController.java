package com.lch.project.book.controller;

import com.lch.project.book.dtos.AddBookDto;
import com.lch.project.book.dtos.BookDto;
import com.lch.project.book.dtos.UpdateBookDto;
import com.lch.project.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping(value = "/books/{id}")
    public BookDto getBook(@PathVariable("id") Integer bookId) {
        return bookService.getBook(bookId);
    }

    @GetMapping(value = "/books")
    public List<BookDto> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping(value = "/books")
    public void addBook(@RequestBody AddBookDto addBookDto) {
        bookService.addBook(addBookDto);
    }

    @PutMapping("/books/{id}")
    public boolean editBook(@PathVariable("id") Integer id, @RequestBody UpdateBookDto updateBookDto) {
        return bookService.updateBook(id, updateBookDto);
    }

    @DeleteMapping("/books/{id}")
    public boolean deleteBook(@PathVariable("id") Integer id) {
        return bookService.deleteBook(id);
    }
}
