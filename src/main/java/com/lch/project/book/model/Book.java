package com.lch.project.book.model;

import com.lch.project.author.model.Author;
import com.lch.project.rating.model.UserRating;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String description;
    private Integer pages;

    @JoinColumn(name = "author_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Author author;

    @OneToMany(cascade = CascadeType.ALL)
    private List<UserRating> userRatings;
}
