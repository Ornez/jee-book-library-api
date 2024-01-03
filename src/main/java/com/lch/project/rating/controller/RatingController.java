package com.lch.project.rating.controller;

import com.lch.project.authorization.service.UserServiceImpl;
import com.lch.project.rating.service.RatingServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
public class RatingController {

    private final RatingServiceImpl ratingService;
    private final UserServiceImpl userService;



//    @GetMapping(value = "/book/rate/{id}")
//    public RatingDto getRating(@PathVariable("id") Integer id) {
//        return ratingService.getRating(id);
//    }
//
//    @PostMapping(value = "/book/rate/{id}")
//    public void addRating(@RequestBody RatingDto ratingDto) {
//        ratingService.addRating(ratingDto);
//    }
//
//    @PutMapping("/book/rate/{id}")
//    public boolean editBook(@RequestBody RatingDto ratingDto) {
//        return ratingService.updateRating(ratingDto);
//    }
}
