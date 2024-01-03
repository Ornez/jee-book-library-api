package com.lch.project.author.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateAuthorDto {
    private String firstname;
    private String surname;
}
