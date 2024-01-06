package com.lch.project.book.service;

import com.lch.project.author.service.AuthorService;
import com.lch.project.book.dtos.AddBookDto;
import com.lch.project.book.dtos.BookDto;
import com.lch.project.author.model.Author;
import com.lch.project.book.dtos.UpdateBookDto;
import com.lch.project.book.model.Book;
import com.lch.project.book.converters.BookMapper;
import com.lch.project.book.repository.BookRepository;
import com.lch.project.book.utils.BookUtils;
import com.lch.project.rating.dtos.FilterRatingDto;
import com.lch.project.rating.model.UserRating;
import com.lch.project.rating.service.RatingService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.experimental.ExtensionMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@ExtensionMethod({BookUtils.class})
public class BookServiceImpl implements BookService {
    @Autowired
    @Lazy
    private AuthorService authorService;
    @Autowired
    @Lazy
    private RatingService ratingService;

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public boolean bookExists(Integer bookId) {
        if (bookId == null)
            return false;

        return bookRepository.existsById(bookId);
    }

    @Override
    public Book getRawBook(Integer id) {
        return bookRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public BookDto getBook(Integer bookId) {
        if (!bookExists(bookId)){
            return null;
        }

        Book book = bookRepository.findById(bookId).orElseThrow(EntityNotFoundException::new);

        FilterRatingDto filterByBook = new FilterRatingDto();
        filterByBook.setBookId(book.getId());
        List<UserRating> userRatings = ratingService.findAll(filterByBook);

        return book.asDto(userRatings);
    }

    @Override
    public List<BookDto> getBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> bookDtos = new ArrayList<>();

        FilterRatingDto filterByBook = new FilterRatingDto();

        for (Book book : books) {
            filterByBook.setBookId(book.getId());
            List<UserRating> userRatings = ratingService.findAll(filterByBook);
            bookDtos.add(book.asDto(userRatings));
        }

        return bookDtos;
    }

    @Override
    public List<Book> getBooksWithAuthor(Author author) {
        return bookRepository.findAllByAuthor(author);
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

        if (updateBookDto.getAuthorId() == null) {
            book.setAuthor(null);
        }
        else if (authorService.authorExists(updateBookDto.getAuthorId())) {
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
