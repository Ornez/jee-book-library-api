package com.lch.project.book.service;

import com.lch.project.book.dtos.BookDto;
import com.lch.project.book.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    boolean bookExists(Integer bookId);
    BookDto getBook(Integer bookId);
    List<BookDto> getBooks();
    void addBook(BookDto bookDto);
    boolean updateBook(BookDto bookDto);
    void deleteBook(Integer bookId);
}
