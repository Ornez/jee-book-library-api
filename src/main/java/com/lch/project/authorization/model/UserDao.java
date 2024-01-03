package com.lch.project.authorization.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lch.project.rating.model.UserRating;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
public class UserDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String username;

    @Column
    @JsonIgnore
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    private List<UserRating> userRatings;
}

