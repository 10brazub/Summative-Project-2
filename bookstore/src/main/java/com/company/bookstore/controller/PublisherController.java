package com.company.bookstore.controller;

import com.company.bookstore.model.Publisher;
import com.company.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class PublisherController {

    @Autowired
    PublisherRepository repo;

    // POST method to add a new Publisher to the repository
    @PostMapping("/publisher")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher addPublisher(@RequestBody Publisher Publisher) {
        return repo.save(Publisher);
    }

    // PUT method to update an existing Publisher in the repository
    @PutMapping("/publisher")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePublisher(@RequestBody Publisher Publisher) {
        repo.save(Publisher);
    }

    // DELETE method to delete a Publisher from the repository by ID
    @DeleteMapping("/publisher/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublisher(@PathVariable int id) {
        repo.deleteById(id);
    }

    // GET method to retrieve a Publisher from the repository by ID
    @GetMapping("/publisher/{id}")
    public Publisher getPublisherById(@PathVariable int id) {
        Optional<Publisher> returnVal = repo.findById(id);
        if (returnVal.isPresent()) { // Check if the publisher exists in the repository
            return returnVal.get(); // Return the publisher if it exists
        } else {
            return null; // Return null if the publisher is not found
        }
    }

    // GET method to retrieve all Publishers from the repository
    @GetMapping("/publisher")
    public List<Publisher> getAllPublishers() {
        return repo.findAll();
    }
}
