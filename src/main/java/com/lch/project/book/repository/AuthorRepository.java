package com.lch.project.book.repository;

import com.lch.project.book.model.Author;
import com.lch.project.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
