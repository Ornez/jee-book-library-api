package com.lch.project.book.service;

import com.lch.project.author.service.AuthorService;
import com.lch.project.author.dtos.AuthorDto;
import com.lch.project.book.dtos.AddBookDto;
import com.lch.project.book.dtos.BookDto;
import com.lch.project.author.model.Author;
import com.lch.project.book.dtos.UpdateBookDto;
import com.lch.project.book.model.Book;
import com.lch.project.book.converters.BookMapper;
import com.lch.project.book.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final AuthorService authorService;
    final private BookRepository bookRepository;
    @Autowired
    final private BookMapper bookMapper;

    @Override
    public boolean bookExists(Integer bookId) {
        return bookRepository.existsById(bookId);
    }

    @Override
    public BookDto getBook(Integer bookId) {
        if (!bookExists(bookId)){
            return null;
        }

        Book book = bookRepository.findById(bookId).orElseThrow(EntityNotFoundException::new);

        Author author = book.getAuthor();
        AuthorDto authorDto = new AuthorDto();
        if (author != null) {
            authorDto = bookMapper.mapAuthorToAuthorDto(author);
        }

        BookDto bookDto =  bookMapper.mapBookToBookDto(book);
        bookDto.setAuthor(authorDto);
        return bookDto;
    }

    @Override
    public List<BookDto> getBooks() {
        return bookRepository
                .findAll().stream()
                .map(bookMapper::mapBookToBookDto)
                .collect(Collectors.toList());
    }

    @Override
    public void addBook(AddBookDto addBookDto) {
        Book book = bookMapper.mapAddBookDtoToBook(addBookDto);
        if (authorService.authorExists(addBookDto.getAuthorId())) {
            Author author = authorService.getRawAuthor(addBookDto.getAuthorId());
            book.setAuthor(author);
        }

        bookRepository.save(book);
    }

    @Override
    public boolean updateBook(Integer id, UpdateBookDto updateBookDto) {
        Book book = bookRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        book.setName(updateBookDto.getName());
        book.setDescription(updateBookDto.getDescription());
        book.setPages(updateBookDto.getPages());

        if (authorService.authorExists(updateBookDto.getAuthorId())) {
            Author author = authorService.getRawAuthor(updateBookDto.getAuthorId());
            book.setAuthor(author);
        }

        bookRepository.save(book);
        return true;
    }

    @Override
    public boolean deleteBook(Integer bookId) {
        if (!bookExists(bookId))
            return false;

        Book book = bookRepository.findById(bookId).orElseThrow(EntityNotFoundException::new);
        book.setAuthor(null);
        bookRepository.save(book);

        bookRepository.deleteById(bookId);
        return true;
    }
}
