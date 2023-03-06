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
    PublisherRepository publisherRepository;

    @PostMapping("/publisher")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Publisher addPublisher(@RequestBody Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @GetMapping("/publisher/{id}")
    public Publisher addPublisherById(@PathVariable int id) {
        Optional<Publisher> returnVal = publisherRepository.findById(id);

        return returnVal.orElse(null);
    }

    @GetMapping("/publisher")
    public List<Publisher> getAllPublisher() {

        return publisherRepository.findAll();
    }

    @PutMapping("/publisher")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updatePublisher(@RequestBody Publisher publisher) {

        publisherRepository.save(publisher);
    }

    @DeleteMapping("/publisher")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deletePublisher(@RequestBody Publisher publisher) {

        publisherRepository.delete(publisher);
    }

}
