package com.demo.spring.repository.impl;

import com.demo.spring.model.Author;
import com.demo.spring.repository.AuthorDAO;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class AuthorDAOImpl extends HibernateDaoSupport implements AuthorDAO {

    public AuthorDAOImpl() {
    }

    public AuthorDAOImpl(SessionFactory sessionfactory) {
        setSessionFactory(sessionfactory);
    }

    @Override
    public Author findById(Long id) {
        return getHibernateTemplate().get(Author.class, id);
    }

    @Override
    public Author findByEmail(String email) {
        return null;
    }

    @Override
    public Author findByName(String name) {
        return null;
    }

    @Override
    public List<Author> searchAuthor(String name, int gender, String email) {
        return null;
    }

}
