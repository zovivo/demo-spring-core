package com.demo.spring.service;

import com.demo.spring.model.Author;
import java.util.List;

public interface AuthorService {
    List<Author> search(String name, Integer gender, String email);
    Author find(Long id);
}