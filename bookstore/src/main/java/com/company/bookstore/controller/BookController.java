package com.company.bookstore.controller;

import com.company.bookstore.model.Book;
import com.company.bookstore.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    BookRepository bookRepository;

    @PostMapping("/book")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addBook(@RequestBody Book book) {

    }


}
