package com.lch.project.rating.service;

import com.lch.project.authorization.model.UserDao;
import com.lch.project.book.model.Book;
import com.lch.project.rating.dtos.AddRatingDto;
import com.lch.project.rating.dtos.FilterRatingDto;
import com.lch.project.rating.dtos.RatingDto;
import com.lch.project.rating.dtos.UpdateRatingDto;
import com.lch.project.rating.model.UserRating;

import java.util.List;

public interface RatingService {

    void addRating(AddRatingDto addRatingDto);
    boolean exists(Integer id);
    List<UserRating> findAll(FilterRatingDto filterRatingDto);
    boolean update(Integer id, UpdateRatingDto updateRatingDto);
    boolean delete(Integer id);
}
