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
        publisher.setName("Publisher Name");
        publisher.setStreet("Street");
        publisher.setCity("City");
        publisher.setState("State");
        publisher.setPostalCode("00000");
        publisher.setPhone("000-000-0000");
        publisher.setEmail("email@email.com");

        publisher = publisherRepo.save(publisher);

        Optional<Publisher> publisher1 = publisherRepo.findById(publisher.getId());
        assertEquals(publisher1.get(), publisher);
    }

    @Test
    public void shouldUpdatePublisher() {

        Publisher publisher = new Publisher();
        publisher.setName("Publisher Name");
        publisher.setStreet("Street");
        publisher.setCity("City");
        publisher.setState("State");
        publisher.setPostalCode("00000");
        publisher.setPhone("000-000-0000");
        publisher.setEmail("email@email.com");

        publisher.setName("Updated Name");
        publisher = publisherRepo.save(publisher);

        Optional<Publisher> publisher1 = publisherRepo.findById(publisher.getId());
        assertEquals(publisher1.get(), publisher);
    }

    @Test
    public void shouldDeletePublisher() {

        Publisher publisher = new Publisher();
        publisher.setName("Publisher Name");
        publisher.setStreet("Street");
        publisher.setCity("City");
        publisher.setState("State");
        publisher.setPostalCode("00000");
        publisher.setPhone("000-000-0000");
        publisher.setEmail("email@email.com");
        publisherRepo.save(publisher);


        publisherRepo.deleteById(publisher.getId());


        Optional<Publisher> publisher1 = publisherRepo.findById(publisher.getId());
        assertFalse(publisher1.isPresent());
    }

    @Test
    public void shouldGetPublisherByID() {

        Publisher publisher = new Publisher();
        publisher.setName("Publisher Name");
        publisher.setStreet("Street");
        publisher.setCity("City");
        publisher.setState("State");
        publisher.setPostalCode("00000");
        publisher.setPhone("000-000-0000");
        publisher.setEmail("email@email.com");
        publisher = publisherRepo.save(publisher);

        Optional<Publisher> foundPublisher = publisherRepo.findById(publisher.getId());


        assertEquals(foundPublisher.get(), publisher);
    }

    @Test
    public void shouldGetAllPublishers() {

        Publisher publisher = new Publisher();
        publisher.setName("Publisher Name");
        publisher.setStreet("Street");
        publisher.setCity("City");
        publisher.setState("State");
        publisher.setPostalCode("00000");
        publisher.setPhone("000-000-0000");
        publisher.setEmail("email@email.com");
        publisherRepo.save(publisher);

        Publisher publisher1 = new Publisher();
        publisher.setName("Publisher Name");
        publisher.setStreet("Street");
        publisher.setCity("City");
        publisher.setState("State");
        publisher.setPostalCode("00000");
        publisher.setPhone("000-000-0000");
        publisher.setEmail("email@email.com");
        publisherRepo.save(publisher1);

        List<Publisher> publisherList = publisherRepo.findAll();

        assertEquals(2, publisherList.size());
    }
}
