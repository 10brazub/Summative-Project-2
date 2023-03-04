package com.company.bookstore.controller;

import com.company.bookstore.model.Book;
import com.company.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @PostMapping("/book")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable int id) {
        Optional<Book> returnVal = bookRepository.findById(id);

        return returnVal.orElse(null);
    }

    @GetMapping("/book")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PutMapping("/book")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateBook(@RequestBody Book book) {
        bookRepository.save(book);
    }

    @DeleteMapping("/book")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteBook(@RequestBody Book book) {
        bookRepository.delete(book);
    }

    @GetMapping("/book/author/{id}")
    public Book getBookByAuthorId(@PathVariable int id) {
        return bookRepository.findByAuthorId(id);

    }

}
