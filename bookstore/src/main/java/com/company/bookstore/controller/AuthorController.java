package com.company.bookstore.controller;

import com.company.bookstore.model.Author;
import com.company.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    // POST method to create a new Author in the repository
    @PostMapping(path = "/author")
    @ResponseStatus(HttpStatus.CREATED)
    public Author createAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    // PUT method to update an existing Author in the repository
    @PutMapping(path = "/author")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Author updateAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    // DELETE method to delete an Author from the repository by ID
    @DeleteMapping(path = "/author/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable Integer id) {
        authorRepository.deleteById(id);
    }

    // GET method to retrieve all Authors from the repository
    @GetMapping("/author")
    public List<Author> readAllBook() {
        return authorRepository.findAll();
    }

    // GET method to retrieve an Author from the repository by ID
    @GetMapping("/author/{id}")
    public Author addAuthorById(@PathVariable int id) {
        Optional<Author> returnVal = authorRepository.findById(id);
        return returnVal.orElse(null); // Return null if the author is not found
    }
}
