package com.lch.project.author.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddAuthorDto {
    private String firstname;
    private String surname;
}
