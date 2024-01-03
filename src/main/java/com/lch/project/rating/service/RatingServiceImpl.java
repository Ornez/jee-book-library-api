package com.lch.project.rating.service;

import com.lch.project.authorization.service.UserServiceImpl;
import com.lch.project.rating.dtos.RatingDto;
import com.lch.project.rating.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RatingServiceImpl implements RatingService {

    final private RatingRepository ratingRepository;
    final private UserServiceImpl userService;

    @Override
    public boolean exists(Integer userId, Integer bookId) {
        return false;
    }

    @Override
    public void create(RatingDto ratingDto) {

    }

    @Override
    public RatingDto get(Integer userId, Integer bookId) {
        return null;
    }

    @Override
    public List<RatingDto> getAllByUser(Integer userId) {
        return null;
    }

    @Override
    public List<RatingDto> getAllByBook(Integer bookId) {
        return null;
    }

    @Override
    public boolean update(RatingDto ratingDto) {
        return false;
    }

    @Override
    public boolean delete(RatingDto ratingDto) {
        return false;
    }
}
