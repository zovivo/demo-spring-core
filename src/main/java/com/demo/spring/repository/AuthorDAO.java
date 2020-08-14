package com.demo.spring.repository;

import com.demo.spring.model.Author;

import java.util.List;

public interface AuthorDAO {

    Author findById(Long id);
    Author create(Author author);
    Author save(Author author);
    Author update(Author author);
    void delete(Author author);
    List<Author> search(String name, int gender, String email);


}
