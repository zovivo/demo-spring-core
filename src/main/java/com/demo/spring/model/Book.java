package com.demo.spring.model;

import java.io.Serializable;
import java.util.List;

public class Book implements Serializable {

    private Long id;
    private String title;
    private List<Author> authors;
    private Integer year;
    private String publisher;
    private Double cost;

    public Book() {
    }

    public Book(String title, List<Author> authors, Integer year, String publisher, Double cost) {
        this.title = title;
        this.authors = authors;
        this.year = year;
        this.publisher = publisher;
        this.cost = cost;
    }

    public Book(String title, Integer year, String publisher, Double cost) {
        this.title = title;
        this.year = year;
        this.publisher = publisher;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
