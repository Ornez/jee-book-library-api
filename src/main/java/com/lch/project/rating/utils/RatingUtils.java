package com.lch.project.rating.utils;

import com.lch.project.authorization.utils.AuthUtils;
import com.lch.project.book.utils.BookUtils;
import com.lch.project.rating.dtos.RatingDto;
import com.lch.project.rating.model.UserRating;
import lombok.experimental.ExtensionMethod;

import java.util.List;

@ExtensionMethod({BookUtils.class, AuthUtils.class})
public class RatingUtils {
    public static RatingDto asDto(UserRating userRating, List<UserRating> bookUserRatings) {
        return RatingDto.builder()
                .id(userRating.getId())
                .book(userRating.getBook().asDto(bookUserRatings))
                .user(userRating.getUser().asDto())
                .rating(userRating.getRating())
                .build();
    }
}
