package com.lch.project.rating.dtos;

import com.lch.project.authorization.model.UserDto;
import com.lch.project.book.dtos.BookDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RatingDto {
    private Integer id;
    private BookDto book;
    private UserDto user;
    private Integer rating;
}
