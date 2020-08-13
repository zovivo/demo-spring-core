package com.demo.spring.repository;

import com.demo.spring.model.Author;

import java.util.List;

public interface AuthorDAO {

    Author findById(Long id);
    Author findByEmail(String email);
    Author findByName(String name);
    List<Author> searchAuthor(String name, int gender, String email);

}
