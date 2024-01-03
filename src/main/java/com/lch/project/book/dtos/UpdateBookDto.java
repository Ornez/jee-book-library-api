package com.lch.project.book.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateBookDto {
    private String name;
    private String description;
    private Integer pages;
    private Integer authorId;
}
