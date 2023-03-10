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
        author.setEmail("email@email.com");
        author.setPhone("111-222-3333");
        author.setFirstName("firstname");
        author.setLastName("lastname");
        author.setStreet("Street");
        author.setPostalCode("99999");
        author.setState("St");
        author.setCity("City");
        author = authorRepository.save(author);

        Optional<Author> author1 = authorRepository.findById(author.getAuthorId());

        assertEquals(author1.get(), author);
    }

    @Test
    public void testReadAllAuthor() {
        // Arrange...
        Author author = new Author();
        author.setEmail("email@email.com");
        author.setPhone("111-222-3333");
        author.setFirstName("firstname");
        author.setLastName("lastname");
        author.setStreet("Street");
        author.setPostalCode("99999");
        author.setState("St");
        author.setCity("City");
        authorRepository.save(author);

        Author author1 = new Author();
        author.setEmail("email@email.com");
        author.setPhone("111-222-3333");
        author.setFirstName("firstname");
        author.setLastName("lastname");
        author.setStreet("Street");
        author.setPostalCode("99999");
        author.setState("St");
        author.setCity("City");
        authorRepository.save(author1);

        List<Author> authors = authorRepository.findAll();

        assertEquals(authors.size(), 2);
    }

    @Test
    public void testUpdateAuthor() {

        Author author = new Author();
        author.setEmail("email@email.com");
        author.setPhone("111-222-3333");
        author.setFirstName("firstname");
        author.setLastName("lastname");
        author.setStreet("Street");
        author.setPostalCode("99999");
        author.setState("St");
        author.setCity("City");
        author = authorRepository.save(author);

        author.setCity("NewCity");
        author.setState("Nc");
        author.setPostalCode("00000");
        author.setStreet("New Street");
        author = authorRepository.save(author);

        Optional<Author> author1 = authorRepository.findById(author.getAuthorId());
        assertEquals(author1.get(), author);
    }
    @Test
    public void testDeleteAuthor() {

        Author author = new Author();
        author.setEmail("email@email.com");
        author.setPhone("111-222-3333");
        author.setFirstName("firstname");
        author.setLastName("lastname");
        author.setStreet("Street");
        author.setPostalCode("99999");
        author.setState("St");
        author.setCity("City");
        authorRepository.save(author);


        authorRepository.deleteById(author.getAuthorId());

        Optional<Author> author1 = authorRepository.findById(author.getAuthorId());
        assertFalse(author1.isPresent());
    }

    @Test
    public void testReadAuthorById() {

        Author author = new Author();
        author.setEmail("test@email.com");
        author.setPhone("111-222-3333");
        author.setFirstName("Test");
        author.setLastName("Author");
        author.setStreet("123 Main St");
        author.setPostalCode("12345");
        author.setState("CA");
        author.setCity("Test City");
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
