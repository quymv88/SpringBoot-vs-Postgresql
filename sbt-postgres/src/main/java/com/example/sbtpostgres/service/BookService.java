package com.example.sbtpostgres.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sbtpostgres.domain.Author;
import com.example.sbtpostgres.domain.Book;


@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private AuthorService authorService;

    public void initBooks() {
        Author author = authorService.getById(1L);
        repository.save(new Book("Java", author));
        repository.save(new Book("Node", author));
        repository.save(new Book("Python", author));
        repository.save(new	Book("Spring Boot", author));
        repository.save(new	Book("C#", author));
        repository.save(new	Book("JPA", author));
    }

    public Book getById(Long id) {
        return repository.findById(id).get();
    }

    public List<Book> getAll() {
        return (List<Book>) repository.findAll();
    }

    @Transactional
    public void batchUpdate() {
        Book book1 = getById(3L);
        book1.setName("Jav");
        repository.save(book1);

        Book book2 = getById(Long.MAX_VALUE);
        book2.setName("Jav");
        repository.save(book2);

    }
}
