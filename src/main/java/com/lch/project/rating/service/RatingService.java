package com.lch.project.rating.service;

import com.lch.project.rating.dtos.RatingDto;

import java.util.List;

public interface RatingService {
    boolean exists(Integer userId, Integer bookId);
    void create(RatingDto ratingDto);
    RatingDto get(Integer userId, Integer bookId);
    List<RatingDto> getAllByUser(Integer userId);
    List<RatingDto> getAllByBook(Integer bookId);
    boolean update(RatingDto ratingDto);
    boolean delete(RatingDto ratingDto);
}
