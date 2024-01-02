package com.lch.project.book.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {
    private Integer id;
    private String name;
    private String description;
    private Integer pages;
    private AuthorDto author;
}
