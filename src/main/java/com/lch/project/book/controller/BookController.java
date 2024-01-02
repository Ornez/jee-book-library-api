package com.lch.project.book.controller;

import com.lch.project.book.dtos.BookDto;
import com.lch.project.book.service.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookServiceImpl bookService;

    @GetMapping(value = "/book/{id}")
    public BookDto getBook(@PathVariable("id") Integer bookId) {
        return bookService.getBook(bookId);
    }

    @GetMapping(value = "/books")
    public List<BookDto> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping(value = "/book")
    public void addBook(@RequestBody BookDto bookDto) {
        bookService.addBook(bookDto);
    }

    @PutMapping("/book")
    public boolean editBook(@RequestBody BookDto bookDto) {
        return bookService.updateBook(bookDto);
    }

    @DeleteMapping("/book/{id}")
    public boolean deleteBook(@PathVariable("id") Integer bookId) {
        if (!bookService.bookExists(bookId))
            return false;

        bookService.deleteBook(bookId);
        return true;
    }

}
