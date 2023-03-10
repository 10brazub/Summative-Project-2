package com.company.bookstore.controller;


import com.company.bookstore.model.Author;
import com.company.bookstore.model.Book;
import com.company.bookstore.model.Publisher;
import com.company.bookstore.repository.AuthorRepository;
import com.company.bookstore.repository.BookRepository;
import com.company.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class GraphQLController {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    PublisherRepository publisherRepository;

    @QueryMapping
    public List<Author> authors() {
        return authorRepository.findAll();
    }

    @QueryMapping
    public Author findAuthorById(@Argument String id) {
        Optional<Author> author = authorRepository.findById(Integer.parseInt(id));
        return author.orElse(null);
        // Return null if author not found
    }

    @QueryMapping
    public List<Publisher> publishers() {
        return publisherRepository.findAll();
    }

    @QueryMapping
    public Publisher findPublisherById(@Argument String id) {
        Optional<Publisher> publisher = publisherRepository.findById(Integer.parseInt(id));
        return publisher.orElse(null);
        // Return null if publisher not found
    }

    @QueryMapping
    public List<Book> books() {
        return bookRepository.findAll();
    }

    @QueryMapping
    public Book findBookById(@Argument String id) {
        Optional<Book> book = bookRepository.findById(Integer.parseInt(id));
        return book.orElse(null);
        // Return null if book not found
    }
}

