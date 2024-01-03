package com.lch.project.book.utils;

import com.lch.project.author.utils.AuthorUtils;
import com.lch.project.book.dtos.BookDto;
import com.lch.project.book.model.Book;
import lombok.experimental.ExtensionMethod;

@ExtensionMethod({AuthorUtils.class})
public class BookUtils {
    public static BookDto asDto(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .description(book.getDescription())
                .pages(book.getPages())
                .author(book.getAuthor().asDto())
                .build();
    }
}
