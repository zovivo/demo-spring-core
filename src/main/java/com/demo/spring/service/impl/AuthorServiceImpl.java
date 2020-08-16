package com.demo.spring.service.impl;

import com.demo.spring.model.Author;
import com.demo.spring.repository.AuthorDAO;
import com.demo.spring.service.AuthorService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class AuthorServiceImpl implements AuthorService {

    private AuthorDAO authorDAO;
    private HibernateTransactionManager transactionManager;

    @Override
    public List<Author> search(String name, Integer gender, String email) {
        return null;
    }

    @Override
    public Author find(Long id) {
        return authorDAO.findById(id);
    }

    @Override
    public Author create(Author author) throws Exception {
        try {
            author = authorDAO.save(author);
            if (author.getName().equals("Nguyen Viet ngoc Quang"))
                throw new Exception("Too weak and short");
        }catch (Exception e){
        }
        return author;
    }

    @Override
    @Transactional( rollbackFor = Exception.class)
    public Author update(Author author) throws Exception {
        author = authorDAO.update(author);
        if (author.getName().equals("Nguyen Viet ngoc Quang")) {
            throw new Exception("Too weak and short");
        }
        return author;
    }

    @Override
    public int delete(Author author) {
        return 0;
    }

    public AuthorDAO getAuthorDAO() {
        return authorDAO;
    }

    public void setAuthorDAO(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    public HibernateTransactionManager getTransactionManager() {
        return transactionManager;
    }

    public void setTransactionManager(HibernateTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
}
