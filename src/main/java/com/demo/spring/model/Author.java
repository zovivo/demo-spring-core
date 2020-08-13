package com.demo.spring.model;

import java.io.Serializable;
import java.util.List;

public class Author implements Serializable {

    private Long id;
    private String name;
    private Integer gender;
    private String email;
    private List<Book> books;

    public Author() {
    }

    public Author(String name, Integer gender, String email, List<Book> books) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
