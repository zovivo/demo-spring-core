package com.demo.spring.repository.impl;

import com.demo.spring.model.Author;
import com.demo.spring.repository.AuthorDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class AuthorDAOImpl extends HibernateDaoSupport implements AuthorDAO {

    @Override
    public Author findById(Long id) {
        return getHibernateTemplate().get(Author.class, id);
    }

    @Override
    public Author create(Author author) {
        Long id = (Long) getHibernateTemplate().save(author);
        return getHibernateTemplate().get(Author.class, id) ;
    }

    @Override
//    @Transactional(rollbackFor = Exception.class)
    public Author save(Author author) throws Exception {
        Session session = getSessionFactory().openSession();
        Long id = (Long) session.save(author);
        return session.get(Author.class, id);
    }

    @Override
    public Author update(Author author) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(author);
            if (author.getName().equals("Nguyen Viet ngoc Quang")) {
                throw new Exception("Too weak and short");
            }
            transaction.commit();
        }catch (Exception e){
            System.err.println("roll back Transaction");
            transaction.rollback();
        }
        return author;
    }

    @Override
    public void delete(Author author) {
        getHibernateTemplate().delete(author);
    }

    @Override
    public List<Author> search(String name, int gender, String email) {
        return null;
    }

    @Override
    public Session getCurrentSession() {
        return getSessionFactory().getCurrentSession();
    }


}
