package com.lch.project.rating.controller;

import com.lch.project.book.utils.BookUtils;
import com.lch.project.rating.dtos.AddRatingDto;
import com.lch.project.rating.dtos.FilterRatingDto;
import com.lch.project.rating.dtos.RatingDto;
import com.lch.project.rating.dtos.UpdateRatingDto;
import com.lch.project.rating.model.UserRating;
import com.lch.project.rating.service.RatingService;
import com.lch.project.rating.utils.RatingUtils;
import lombok.RequiredArgsConstructor;
import lombok.experimental.ExtensionMethod;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@ExtensionMethod({RatingUtils.class})
public class RatingController {
    private final RatingService ratingService;

    @PostMapping(value = "/ratings")
    public void addRating(@RequestBody AddRatingDto addRatingDto) {
        ratingService.addRating(addRatingDto);
    }

    @GetMapping(value = "/ratings")
    public List<RatingDto> getRating(@RequestParam Optional<String> username, @RequestParam Optional<Integer> bookId) {
        FilterRatingDto filterRatingDto = new FilterRatingDto();
        username.ifPresent(filterRatingDto::setUsername);
        bookId.ifPresent(filterRatingDto::setBookId);

        List<UserRating> userRatings = ratingService.findAll(filterRatingDto);
        List<RatingDto> ratingDtos = new LinkedList<>();
        userRatings.forEach(userRating -> {
            FilterRatingDto filterByBook = new FilterRatingDto();
            filterByBook.setBookId(userRating.getBook().getId());
            var ratingRelatedWithBook = ratingService.findAll(filterByBook);
            ratingDtos.add(userRating.asDto(ratingRelatedWithBook));
        });
        return ratingDtos;
    }

    @PutMapping(value = "/ratings/{id}")
    public boolean updateRating(@PathVariable("id") Integer id, @RequestBody UpdateRatingDto updateRatingDto) {
        return ratingService.update(id, updateRatingDto);
    }

    @DeleteMapping(value = "/ratings/{id}")
    public boolean deleteRating(@PathVariable("id") Integer id) {
        return ratingService.delete(id);
    }
}
