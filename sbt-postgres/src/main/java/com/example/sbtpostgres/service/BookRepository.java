package com.example.sbtpostgres.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.sbtpostgres.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByName(String name);

}
