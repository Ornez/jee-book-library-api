package com.lch.project.book.converters;

import com.lch.project.book.dtos.AuthorDto;
import com.lch.project.book.dtos.BookDto;
import com.lch.project.book.model.Author;
import com.lch.project.book.model.Book;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Mapper(componentModel = "spring")
@Repository
public interface BookMapper {
    BookDto mapBookToBookDto (Book book);
    Book mapBookDtoToBook (BookDto bookDto);
    AuthorDto mapAuthorToAuthorDto(Author author);
    Author mapAuthorDtoToAuthor (AuthorDto authorDto);
}
