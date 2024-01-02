package com.lch.project.book.service;

import com.lch.project.book.dtos.AuthorDto;
import com.lch.project.book.dtos.BookDto;
import com.lch.project.book.model.Author;
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
    private final AuthorServiceImpl authorService;
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
    public void addBook(BookDto bookDto) {
        Book book = bookMapper.mapBookDtoToBook(bookDto);
        if (authorService.authorExists(bookDto.getAuthor().getId())) {
            Author author = authorService.getRawAuthor(bookDto.getAuthor().getId());
            book.setAuthor(author);
        }

        bookRepository.save(book);
    }

    @Override
    public boolean updateBook(BookDto bookDto) {
        Book book = bookRepository.findById(bookDto.getId()).orElseThrow(EntityNotFoundException::new);
        book.setName(bookDto.getName());
        book.setDescription(bookDto.getDescription());
        book.setPages(bookDto.getPages());

        if (authorService.authorExists(bookDto.getAuthor().getId())) {
            Author author = authorService.getRawAuthor(bookDto.getAuthor().getId());
            book.setAuthor(author);
        }

        bookRepository.save(book);
        return true;
    }

    @Override
    public void deleteBook(Integer bookId) {
        bookRepository.deleteById(bookId);
    }
}
