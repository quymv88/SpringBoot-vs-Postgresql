package com.example.sbtpostgres;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.sbtpostgres.service.AuthorService;
import com.example.sbtpostgres.service.BookService;

@SpringBootApplication
public class StartApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    public static void main(String[] args) {
        log.info("Start application");
        SpringApplication.run(StartApplication.class, args);
    }

    @Override
    public void run(String... args) {
        authorService.initAuthors();
        bookService.initBooks();
        bookService.getAll().forEach(x -> System.out.println(x));

        try {
            bookService.batchUpdate();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        
    }


}
