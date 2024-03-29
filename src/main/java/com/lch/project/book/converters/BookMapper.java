package com.lch.project.book.converters;

import com.lch.project.author.dtos.AddAuthorDto;
import com.lch.project.author.dtos.AuthorDto;
import com.lch.project.book.dtos.AddBookDto;
import com.lch.project.book.dtos.BookDto;
import com.lch.project.author.model.Author;
import com.lch.project.book.model.Book;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Mapper(componentModel = "spring")
@Repository
public interface BookMapper {
    BookDto mapBookToBookDto (Book book);
    Book mapAddBookDtoToBook(AddBookDto addBookDto);
    AuthorDto mapAuthorToAuthorDto(Author author);
}
