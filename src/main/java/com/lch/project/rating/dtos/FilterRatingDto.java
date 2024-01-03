package com.lch.project.rating.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilterRatingDto {
    private String username;
    private Integer bookId;
}
