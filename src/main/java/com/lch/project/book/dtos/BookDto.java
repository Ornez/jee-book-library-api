package com.lch.project.book.dtos;

import com.lch.project.author.dtos.AuthorDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BookDto {
    private Integer id;
    private String name;
    private String description;
    private Integer pages;
    private AuthorDto author;
}
