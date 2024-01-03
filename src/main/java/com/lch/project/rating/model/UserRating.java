package com.lch.project.rating.model;

import com.lch.project.authorization.model.UserDao;
import com.lch.project.book.model.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserRating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer rating;

    @JoinColumn(name = "book_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Book book;

    @JoinColumn(name = "user_id")
    @OneToOne(cascade = CascadeType.ALL)
    private UserDao user;
}
