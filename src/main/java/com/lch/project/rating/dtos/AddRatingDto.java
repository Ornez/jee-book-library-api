package com.lch.project.rating.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddRatingDto {
    private Integer bookId;
    private String username;
    private Integer rating;
}
