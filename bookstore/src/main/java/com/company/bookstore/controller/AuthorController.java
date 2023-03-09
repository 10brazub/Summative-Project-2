package com.company.bookstore.controller;

import com.company.bookstore.model.Author;
import com.company.bookstore.model.Publisher;
import com.company.bookstore.repository.AuthorRepository;
import com.company.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;
    @PostMapping(path = "/author")
    @ResponseStatus(HttpStatus.CREATED)
    public Author createAuthor(@RequestBody Author author) {
        return author = authorRepository.save(author);
    }
    @PutMapping(path = "/author")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Author updateAuthor(@RequestBody Author author) {
        return author = authorRepository.save(author);
    }

    @DeleteMapping(path = "/author/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable Integer id) {
        authorRepository.deleteById(id);
    }
    @GetMapping("/author")
    public List<Author> readAllBook() {
        List<Author> authorList = authorRepository.findAll();
        return authorList;
    }

}
