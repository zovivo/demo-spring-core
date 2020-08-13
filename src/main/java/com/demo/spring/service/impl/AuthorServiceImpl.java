package com.demo.spring.service.impl;

import com.demo.spring.model.Author;
import com.demo.spring.repository.AuthorDAO;
import com.demo.spring.service.AuthorService;
import java.util.List;


public class AuthorServiceImpl implements AuthorService {

    private AuthorDAO authorDAO;

    @Override
    public List<Author> search(String name, Integer gender, String email) {
        return null;
    }

    @Override
    public Author find(Long id) {
        return authorDAO.findById(id);
    }

    public AuthorDAO getAuthorDAO() {
        return authorDAO;
    }

    public void setAuthorDAO(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }
}
