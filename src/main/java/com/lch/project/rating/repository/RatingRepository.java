package com.lch.project.rating.repository;

import com.lch.project.authorization.model.UserDao;
import com.lch.project.book.model.Book;
import com.lch.project.rating.model.UserRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<UserRating, Integer> {

    List<UserRating> findAllByBookAndUser(Book book, UserDao user);
    List<UserRating> findAllByBook(Book book);
    List<UserRating> findAllByUser(UserDao user);

    //    @Query(value = "SELECT * FROM UserRating WHERE book.id = ?1 AND user.id = ?2", nativeQuery = true)
    //    UserRating findByBookAndUser(Integer userId, Integer bookId);
    //
    //    @Query(value = "SELECT * FROM UserRating WHERE book.id = ?1", nativeQuery = true)
    //    List<UserRating> findByBook(Integer bookId);
    //
    //    @Query(value = "SELECT * FROM UserRating WHERE user.id = ?1", nativeQuery = true)
    //    List<UserRating> findByUser(Integer userId);
}
