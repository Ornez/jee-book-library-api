package com.lch.project.book.utils;

import com.lch.project.author.utils.AuthorUtils;
import com.lch.project.book.dtos.BookDto;
import com.lch.project.book.model.Book;
import com.lch.project.rating.model.UserRating;
import lombok.experimental.ExtensionMethod;

import java.util.List;
import java.util.stream.Collectors;

@ExtensionMethod({AuthorUtils.class})
public class BookUtils {
    public static BookDto asDto(Book book, List<UserRating> userRatings) {
        return BookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .description(book.getDescription())
                .pages(book.getPages())
                .author(book.getAuthor().asDto())
                .averageRating(userRatings.stream().map(UserRating::getRating).toList()
                        .stream().collect(Collectors.averagingDouble(num -> num)))
                .numberOfVotes(userRatings.size())
                .build();
    }
}
