package com.lch.project.book.repository;

import com.lch.project.author.model.Author;
import com.lch.project.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllByAuthor(Author author);
}