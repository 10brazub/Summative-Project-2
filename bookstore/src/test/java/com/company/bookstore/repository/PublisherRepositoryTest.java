package com.company.bookstore.repository;

import com.company.bookstore.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PublisherRepositoryTest {
    @Autowired
    PublisherRepository publisherRepo;

    @Before
    public void setUp() throws Exception { publisherRepo.deleteAll(); }

    @Test
    public void shouldCreateNewPublisher() {

        Publisher publisher = new Publisher();
        publisher.setName("Penguin Random House");
        publisher.setStreet("1745 Broadway");
        publisher.setCity("New York City");
        publisher.setState("New York");
        publisher.setPostalCode("10019");
        publisher.setPhone("800-793-2665");
        publisher.setEmail("penguinrandomhouse@gmail.com");

        publisher = publisherRepo.save(publisher);

        Optional<Publisher> publisher1 = publisherRepo.findById(publisher.getId());
        assertEquals(publisher1.get(), publisher);
    }

    @Test
    public void shouldUpdatePublisher() {

        Publisher publisher = new Publisher();
        publisher.setName("Penguin Random House");
        publisher.setStreet("1745 Broadway");
        publisher.setCity("New York City");
        publisher.setState("New York");
        publisher.setPostalCode("10019");
        publisher.setPhone("800-793-2665");
        publisher.setEmail("penguinrandomhouse@gmail.com");

        publisher.setName("Penguin || Random House");
        publisher = publisherRepo.save(publisher);

        Optional<Publisher> publisher1 = publisherRepo.findById(publisher.getId());
        assertEquals(publisher1.get(), publisher);
    }

    @Test
    public void shouldDeletePublisher() {

        Publisher publisher = new Publisher();
        publisher.setName("Penguin Random House");
        publisher.setStreet("1745 Broadway");
        publisher.setCity("New York City");
        publisher.setState("New York");
        publisher.setPostalCode("10019");
        publisher.setPhone("800-793-2665");
        publisher.setEmail("penguinrandomhouse@gmail.com");
        publisherRepo.save(publisher);


        publisherRepo.deleteById(publisher.getId());


        Optional<Publisher> publisher1 = publisherRepo.findById(publisher.getId());
        assertFalse(publisher1.isPresent());
    }

    @Test
    public void shouldGetPublisherByID() {

        Publisher publisher = new Publisher();
        publisher.setName("Penguin Random House");
        publisher.setStreet("1745 Broadway");
        publisher.setCity("New York City");
        publisher.setState("New York");
        publisher.setPostalCode("10019");
        publisher.setPhone("800-793-2665");
        publisher.setEmail("penguinrandomhouse@gmail.com");
        publisher = publisherRepo.save(publisher);

        Optional<Publisher> foundPublisher = publisherRepo.findById(publisher.getId());


        assertEquals(foundPublisher.get(), publisher);
    }

    @Test
    public void shouldGetAllPublishers() {

        Publisher publisher = new Publisher();
        publisher.setName("Penguin Random House");
        publisher.setStreet("1745 Broadway");
        publisher.setCity("New York City");
        publisher.setState("New York");
        publisher.setPostalCode("10019");
        publisher.setPhone("800-793-2665");
        publisher.setEmail("penguinrandomhouse@gmail.com");
        publisherRepo.save(publisher);

        Publisher publisher1 = new Publisher();
        publisher1.setName("J.K. Rowling Publishing");
        publisher1.setStreet("232 Maple St");
        publisher1.setCity("New York City");
        publisher1.setState("New York");
        publisher1.setPostalCode("92422");
        publisher1.setPhone("859-429-3920");
        publisher1.setEmail("jkRowling@gmail.com");
        publisherRepo.save(publisher1);

        List<Publisher> publisherList = publisherRepo.findAll();

        assertEquals(2, publisherList.size());
    }
}
