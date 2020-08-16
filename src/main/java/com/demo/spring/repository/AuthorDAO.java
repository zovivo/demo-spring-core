package com.demo.spring.repository;

import com.demo.spring.model.Author;
import org.hibernate.Session;

import java.util.List;

public interface AuthorDAO {

    Author findById(Long id);
    Author create(Author author);

    Author save(Author author) throws Exception;
    Author update(Author author);
    void delete(Author author);
    List<Author> search(String name, int gender, String email);

    Session getCurrentSession();


}
