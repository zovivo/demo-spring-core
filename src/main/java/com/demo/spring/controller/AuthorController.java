package com.demo.spring.controller;

import com.demo.spring.model.Author;
import com.demo.spring.service.AuthorService;

public class AuthorController {

    private AuthorService authorService;

    public Author findById(Long id){
        return authorService.find(id);
    }

    public AuthorService getAuthorService() {
        return authorService;
    }

    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }
}
