package com.example.sbtpostgres.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Version
    @Column(name = "VERSION")
    private long version;

    @ManyToOne
    private Author author;

    public Book() {
    }

    public Book(String name, Author author) {
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book {" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}' + " Author: " + this.author.getName();
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

    public long getVersion() {
        return version;
    }

    public void setVersion(Long v) {
        this.version = v;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}