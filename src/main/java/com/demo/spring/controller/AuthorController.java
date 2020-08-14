package com.demo.spring.controller;

import com.demo.spring.model.Author;
import com.demo.spring.service.AuthorService;

public class AuthorController {

    private AuthorService authorService;
    private String beanScopeMessage;

    public Author findById(Long id){
        return authorService.find(id);
    }

    public Author create(Author author){

        try {
           author = authorService.create(author);
        }catch (Exception e){
            System.out.println(e);
        }
        return author;
    }

    public Author update(Author author){
        return authorService.update(author);
    }

    public int delete(Author author){
        return authorService.delete(author);
    }

    public AuthorService getAuthorService() {
        return authorService;
    }

    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    public String getBeanScopeMessage() {
        return beanScopeMessage;
    }

    public void setBeanScopeMessage(String beanScopeMessage) {
        this.beanScopeMessage = beanScopeMessage;
    }
}
