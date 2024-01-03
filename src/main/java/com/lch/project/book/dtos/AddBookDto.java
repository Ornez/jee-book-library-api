package com.lch.project.book.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddBookDto {
    private String name;
    private String description;
    private Integer pages;
    private Integer authorId;
}
