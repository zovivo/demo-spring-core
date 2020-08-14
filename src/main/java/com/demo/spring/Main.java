package com.demo.spring;

import com.demo.spring.controller.AuthorController;
import com.demo.spring.model.Author;
import com.demo.spring.model.Book;
import com.demo.spring.utils.CustomerBo;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        // loading the definitions from the given XML file
        ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml", "config/hibernateConfig.xml", "config/aopConfig.xml", "config/controllerBeans.xml", "config/serviceBeans.xml", "config/repositoryBeans.xml");
//        displayAllBeans(context);
        createData(context);
        AuthorController authorController = (AuthorController) context.getBean("authorController");
        Author author = authorController.findById(1L);
        System.err.println("author: " + author);
        testBeanScope(context);

        testAOP(context);
    }

    public static void testBeanScope(ApplicationContext context) {
        System.out.println("=======Test Bean Scope=======");

        AuthorController authorControllerSingleton1 = (AuthorController) context.getBean("authorController");
        authorControllerSingleton1.setBeanScopeMessage("this is singleton scope");
        System.out.println("bean message: " + authorControllerSingleton1.getBeanScopeMessage());
        AuthorController authorControllerSingleton2 = (AuthorController) context.getBean("authorController");
        System.out.println("bean message: " + authorControllerSingleton2.getBeanScopeMessage());

        AuthorController authorControllerPrototype1 = (AuthorController) context.getBean("authorControllerPrototype");
        authorControllerPrototype1.setBeanScopeMessage("this is prototype scope");
        System.out.println("bean message: " + authorControllerPrototype1.getBeanScopeMessage());
        AuthorController authorControllerPrototype2 = (AuthorController) context.getBean("authorControllerPrototype");
        System.out.println("bean message: " + authorControllerPrototype2.getBeanScopeMessage());

        System.out.println("=======Test Bean Scope=======");
    }

    public static void testAOP(ApplicationContext context) {
        System.out.println("=======Test AOP Spring=======");
        CustomerBo customer = (CustomerBo) context.getBean("customerBo");
        customer.addCustomer();
        System.out.println("=======Test AOP Spring=======");
    }

    public static void displayAllBeans(ApplicationContext applicationContext) {
        String[] allBeanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : allBeanNames) {
            System.out.println(beanName);
        }
    }

    public static void createData(ApplicationContext context) {
        AuthorController authorController = (AuthorController) context.getBean("authorController");
//        SessionFactory sessionFactory = context.getBean("sessionFactory", SessionFactory.class);
//        Session session = sessionFactory.openSession();
//        Transaction transaction = null;

        try {
//            transaction = session.beginTransaction();
            Author author = new Author();
            author.setName("Nguyen Viet ngoc Quang");
            author.setEmail("boiz_dan_phuong@gmail.com");
            author.setGender(1);
            List<Book> books = new ArrayList<>();
            Book book1 = new Book("Core Java", 1998, "NXB Giao duc", 15.6d);
            Book book2 = new Book("Spring for Beginners", 2015, "NXB Giao duc", 19.6d);
            books.addAll(Arrays.asList(book1, book2));
            author.setBooks(books);
            authorController.create(author);
//            session.save(author);
//            transaction.commit();
        } catch (Exception e) {
//            logger.error("Roll back!!!");
//            transaction.rollback();
            logger.error(e.getMessage(), e);
        }
    }
}
