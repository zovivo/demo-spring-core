package com.demo.spring;

import com.demo.spring.controller.AuthorController;
import com.demo.spring.model.Author;
import com.demo.spring.model.Book;
import com.demo.spring.utils.CustomerBo;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        // loading the definitions from the given XML file
        ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml", "config/hibernateConfig.xml", "config/Spring-Customer.xml","config/controllerBeans.xml","config/serviceBeans.xml","config/repositoryBeans.xml");
//        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"))
        displayAllBeans(context);
        createData(context);
//        CustomerBo customer = (CustomerBo) context.getBean("customerBo");
//        customer.addCustomer();
        AuthorController authorController = (AuthorController) context.getBean("authorController");
        Author author =  authorController.findById(1L);
        System.err.println("author: "+author);
    }

    public static void displayAllBeans(ApplicationContext applicationContext) {
        String[] allBeanNames = applicationContext.getBeanDefinitionNames();
        for(String beanName : allBeanNames) {
            System.out.println(beanName);
        }
    }

    public static void createData(ApplicationContext context){
        SessionFactory sessionFactory = context.getBean("sessionFactory", SessionFactory.class);
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Author author = new Author();
            author.setName("Nguyen Viet ngoc Quang");
            author.setEmail("boiz_dan_phuong@gmail.com");
            author.setGender(1);
            List<Book> books = new ArrayList<>();
            Book book1 = new Book("Core Java", 1998, "NXB Giao duc", 15.6d);
            Book book2 = new Book("Spring for Beginners", 2015, "NXB Giao duc", 19.6d);
            books.addAll(Arrays.asList(book1,book2));
            author.setBooks(books);
            session.save(author);
            transaction.commit();
        }catch (Exception e){
            logger.error("Roll back!!!");
            transaction.rollback();
            logger.error(e.getMessage(), e);
        }finally {
            session.close();
        }
    }
}
