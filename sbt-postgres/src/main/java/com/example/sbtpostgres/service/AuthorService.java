package com.example.sbtpostgres.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sbtpostgres.domain.Author;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;

    public void initAuthors() {
        repository.save(new Author("QuyMV"));
        repository.save(new Author("John"));
    }

    public Author getById(Long id) {
        return repository.findById(id).get();
    }

    public List<Author> getAll() {
        return (List<Author>) repository.findAll();
    }
}
