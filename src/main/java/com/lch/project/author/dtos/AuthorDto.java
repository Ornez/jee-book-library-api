package com.lch.project.author.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDto {
    private Integer id;
    private String firstname;
    private String surname;
}
