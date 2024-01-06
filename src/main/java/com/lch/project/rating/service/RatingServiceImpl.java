package com.lch.project.rating.service;

import com.lch.project.authorization.model.UserDao;
import com.lch.project.authorization.service.UserService;
import com.lch.project.book.model.Book;
import com.lch.project.book.service.BookService;
import com.lch.project.rating.dtos.AddRatingDto;
import com.lch.project.rating.dtos.FilterRatingDto;
import com.lch.project.rating.dtos.UpdateRatingDto;
import com.lch.project.rating.model.UserRating;
import com.lch.project.rating.repository.RatingRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RatingServiceImpl implements RatingService {
    private final RatingRepository ratingRepository;
    @Autowired
    @Lazy
    private BookService bookService;
    @Autowired
    @Lazy
    private UserService userService;

    @Override
    public void addRating(AddRatingDto addRatingDto) {
        UserRating userRating = new UserRating();

        Book book = bookService.getRawBook(addRatingDto.getBookId());
        UserDao user = userService.findByUsername(addRatingDto.getUsername());

        userRating.setRating(addRatingDto.getRating());
        userRating.setUser(user);
        userRating.setBook(book);

        ratingRepository.save(userRating);
    }

    @Override
    public boolean exists(Integer id) {
        return ratingRepository.existsById(id);
    }

    @Override
    public List<UserRating> findAll(FilterRatingDto filterRatingDto) {
        if (filterRatingDto.getUsername() != null && filterRatingDto.getBookId() != null) {
            Book book = bookService.getRawBook(filterRatingDto.getBookId());
            UserDao user = userService.findByUsername(filterRatingDto.getUsername());

            return ratingRepository.findAllByBookAndUser(book, user);
        }
        else if (filterRatingDto.getUsername() != null) {
            UserDao user = userService.findByUsername(filterRatingDto.getUsername());
            return ratingRepository.findAllByUser(user);
        }
        else if (filterRatingDto.getBookId() != null) {
            Book book = bookService.getRawBook(filterRatingDto.getBookId());
            return ratingRepository.findAllByBook(book);
        }

        return ratingRepository.findAll();
    }

    @Override
    public boolean update(Integer id, UpdateRatingDto updateRatingDto) {
        if (!exists(id))
            return false;

        UserRating userRating = ratingRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        userRating.setRating(updateRatingDto.getRating());

        ratingRepository.save(userRating);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        if (!exists(id))
            return false;

        UserRating userRating = ratingRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        userRating.setBook(null);
        userRating.setUser(null);
        ratingRepository.save(userRating);
        ratingRepository.deleteById(id);
        return true;
    }
}
