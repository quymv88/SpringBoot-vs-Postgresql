package com.example.sbtpostgres.service;

import org.springframework.data.repository.CrudRepository;

import com.example.sbtpostgres.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
