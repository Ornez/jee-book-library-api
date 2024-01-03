package com.lch.project.book.service;

import com.lch.project.author.model.Author;
import com.lch.project.book.dtos.AddBookDto;
import com.lch.project.book.dtos.BookDto;
import com.lch.project.book.dtos.UpdateBookDto;
import com.lch.project.book.model.Book;

import java.util.List;

public interface BookService {
    boolean bookExists(Integer bookId);
    BookDto getBook(Integer bookId);
    List<BookDto> getBooks();
    List<Book> getBooksWithAuthor(Author author);
    void addBook(AddBookDto addBookDto);
    boolean updateBook(Integer id, UpdateBookDto updateBookDto);
    boolean deleteBook(Integer bookId);
}
