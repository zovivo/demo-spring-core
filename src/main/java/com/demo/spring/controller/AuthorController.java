package com.demo.spring.controller;

import com.demo.spring.model.Author;
import com.demo.spring.service.AuthorService;
import org.apache.log4j.Logger;

public class AuthorController {

    private AuthorService authorService;
    private String beanScopeMessage;
    private Logger logger = Logger.getLogger(AuthorController.class);

    public Author findById(Long id) {
        return authorService.find(id);
    }

    public Author create(Author author) throws Exception {
        author = authorService.create(author);
        return author;
    }

    public Author update(Author author) {
        try {
            author = authorService.update(author);
        } catch (Exception e) {
            logger.info(e);
        }
        return author;
    }

    public int delete(Author author) {
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
