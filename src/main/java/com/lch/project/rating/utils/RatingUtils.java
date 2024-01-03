package com.lch.project.rating.utils;

import com.lch.project.authorization.utils.AuthUtils;
import com.lch.project.book.utils.BookUtils;
import com.lch.project.rating.dtos.RatingDto;
import com.lch.project.rating.model.UserRating;
import lombok.experimental.ExtensionMethod;

@ExtensionMethod({BookUtils.class, AuthUtils.class})
public class RatingUtils {
    public static RatingDto asDto(UserRating userRating) {
        return RatingDto.builder()
                .id(userRating.getId())
                .bookDto(userRating.getBook().asDto())
                .userDto(userRating.getUser().asDto())
                .rating(userRating.getRating())
                .build();
    }
}
