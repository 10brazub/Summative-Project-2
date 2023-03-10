package com.company.bookstore.repository;

import com.company.bookstore.model.Author;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authorRepository;
    @Before
    public void setUp() throws Exception {
        authorRepository.deleteAll();
    }
    @Test
    public void testCreateAuthor() {

        Author author = new Author();
        author.setEmail("pkd@gmail.com");
        author.setPhone("849-242-1412");
        author.setFirstName("Philip");
        author.setLastName("Dick");
        author.setStreet("1312 Hopkins Ave");
        author.setPostalCode("60601");
        author.setState("Illinois");
        author.setCity("Chicago");
        author = authorRepository.save(author);

        Optional<Author> author1 = authorRepository.findById(author.getAuthorId());

        assertEquals(author1.get(), author);
    }

    @Test
    public void testReadAllAuthor() {
        Author author = new Author();
        author.setEmail("pkd@gmail.com");
        author.setPhone("849-242-1412");
        author.setFirstName("Philip");
        author.setLastName("Dick");
        author.setStreet("1312 Hopkins Ave");
        author.setPostalCode("60601");
        author.setState("Illinois");
        author.setCity("Chicago");
        authorRepository.save(author);

        Author author1 = new Author();
        author.setEmail("fHerbert@gmail.com");
        author.setPhone("832-401-4923");
        author.setFirstName("Frank");
        author.setLastName("Herbert");
        author.setStreet("9402 Sunny Dr");
        author.setPostalCode("98406");
        author.setState("Tacoma");
        author.setCity("Washington");
        authorRepository.save(author1);

        List<Author> authors = authorRepository.findAll();

        assertEquals(authors.size(), 2);
    }

    @Test
    public void testUpdateAuthor() {

        Author author = new Author();
        author.setEmail("pkd@gmail.com");
        author.setPhone("849-242-1412");
        author.setFirstName("Philip");
        author.setLastName("Dick");
        author.setStreet("1312 Hopkins Ave");
        author.setPostalCode("60601");
        author.setState("Illinois");
        author.setCity("Chicago");
        author = authorRepository.save(author);

        author.setCity("Santa Ana");
        author.setState("California");
        author.setPostalCode("92705");
        author.setStreet("19001 Beverly Ave");
        author = authorRepository.save(author);

        Optional<Author> author1 = authorRepository.findById(author.getAuthorId());
        assertEquals(author1.get(), author);
    }
    @Test
    public void testDeleteAuthor() {

        Author author = new Author();
        author.setEmail("pkd@gmail.com");
        author.setPhone("849-242-1412");
        author.setFirstName("Philip");
        author.setLastName("Dick");
        author.setStreet("1312 Hopkins Ave");
        author.setPostalCode("60601");
        author.setState("Illinois");
        author.setCity("Chicago");
        authorRepository.save(author);


        authorRepository.deleteById(author.getAuthorId());

        Optional<Author> author1 = authorRepository.findById(author.getAuthorId());
        assertFalse(author1.isPresent());
    }

    @Test
    public void testReadAuthorById() {

        Author author = new Author();
        author.setEmail("pkd@gmail.com");
        author.setPhone("849-242-1412");
        author.setFirstName("Philip");
        author.setLastName("Dick");
        author.setStreet("1312 Hopkins Ave");
        author.setPostalCode("60601");
        author.setState("Illinois");
        author.setCity("Chicago");
        authorRepository.save(author);

        Optional<Author> optionalAuthor = authorRepository.findById(author.getAuthorId());

        assertTrue(optionalAuthor.isPresent());
        assertEquals(author.getAuthorId(), optionalAuthor.get().getAuthorId());
        assertEquals(author.getEmail(), optionalAuthor.get().getEmail());
        assertEquals(author.getPhone(), optionalAuthor.get().getPhone());
        assertEquals(author.getFirstName(), optionalAuthor.get().getFirstName());
        assertEquals(author.getLastName(), optionalAuthor.get().getLastName());
        assertEquals(author.getStreet(), optionalAuthor.get().getStreet());
        assertEquals(author.getPostalCode(), optionalAuthor.get().getPostalCode());
        assertEquals(author.getState(), optionalAuthor.get().getState());
        assertEquals(author.getCity(), optionalAuthor.get().getCity());
    }
}
