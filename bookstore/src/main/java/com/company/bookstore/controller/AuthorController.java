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

    @PostMapping("/author")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Author addAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    @GetMapping("/author/{id}")
    public Author addAuthorById(@PathVariable int id) {
        Optional<Author> returnVal = authorRepository.findById(id);

        return returnVal.orElse(null);
    }

    @GetMapping("/author")
    public List<Author> getAllAuthors() {

        return authorRepository.findAll();
    }

    @PutMapping("/author")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateAuthor(@RequestBody Author author) {

        authorRepository.save(author);
    }

    @DeleteMapping("/author")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteAuthor(@RequestBody Author author) {

        authorRepository.delete(author);
    }

}
