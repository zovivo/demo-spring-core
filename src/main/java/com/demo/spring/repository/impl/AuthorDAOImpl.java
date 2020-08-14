package com.demo.spring.repository.impl;

import com.demo.spring.model.Author;
import com.demo.spring.repository.AuthorDAO;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class AuthorDAOImpl extends HibernateDaoSupport implements AuthorDAO {

    @Override
    public Author findById(Long id) {
        return getHibernateTemplate().get(Author.class, id);
    }

//    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Author create(Author author) {
        Long id = (Long) getHibernateTemplate().save(author);
        return getHibernateTemplate().get(Author.class, id) ;
    }

    @Override
    public Author save(Author author) {
        Session session = getSessionFactory().openSession();
        Long id = (Long) session.save(author);
        return session.get(Author.class, id);
    }

    @Override
    public Author update(Author author) {
        return getHibernateTemplate().merge(author);
    }

    @Override
    public void delete(Author author) {
        getHibernateTemplate().delete(author);
    }

    @Override
    public List<Author> search(String name, int gender, String email) {
        return null;
    }


}
