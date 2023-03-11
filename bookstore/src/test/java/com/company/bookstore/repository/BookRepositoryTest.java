package com.company.bookstore.repository;

import com.company.bookstore.model.Author;
import com.company.bookstore.model.Book;
import com.company.bookstore.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PublisherRepository publisherRepository;

    @Before
    public void setUp() throws Exception {
        bookRepository.deleteAll();
        authorRepository.deleteAll();
        publisherRepository.deleteAll();
    }

    @Test
    public void shouldAddBook() {
        Author author = new Author();
        author.setFirstName("J.K.");
        author.setLastName("Rowling");
        author.setStreet("232 Maple St");
        author.setCity("New York City");
        author.setState("New York");
        author.setPostalCode("92422");
        author.setPhone("859-429-3920");
        author.setEmail("jkRowling@gmail.com");
        author = authorRepository.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("J.K. Rowling Publishing");
        publisher.setStreet("232 Maple St");
        publisher.setCity("New York City");
        publisher.setState("New York");
        publisher.setPostalCode("92422");
        publisher.setPhone("859-429-3920");
        publisher.setEmail("jkRowling@gmail.com");
        publisher = publisherRepository.save(publisher);

        Book book = new Book();
        book.setPublisherId(publisher.getId());
        book.setAuthorId(author.getAuthorId());
        book.setIsbn("38309302");
        book.setPublishDate("03-23-2013");
        book.setTitle("The Messenger");
        book.setPrice("12.45");
        bookRepository.save(book);

        Optional<Book> book1 = bookRepository.findById(book.getBookId());

        assertEquals(book1.get(), book);
    }

    @Test
    public void shouldGetBookById () {
        Author author = new Author();
        author.setFirstName("J.K.");
        author.setLastName("Rowling");
        author.setStreet("232 Maple St");
        author.setCity("New York City");
        author.setState("New York");
        author.setPostalCode("92422");
        author.setPhone("859-429-3920");
        author.setEmail("jkRowling@gmail.com");
        author = authorRepository.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("J.K. Rowling Publishing");
        publisher.setStreet("232 Maple St");
        publisher.setCity("New York City");
        publisher.setState("New York");
        publisher.setPostalCode("92422");
        publisher.setPhone("859-429-3920");
        publisher.setEmail("jkRowling@gmail.com");
        publisher = publisherRepository.save(publisher);

        Book book = new Book();
        book.setAuthorId(author.getAuthorId());
        book.setPublisherId(publisher.getId());
        book.setIsbn("38309302");
        book.setPublishDate("03-23-2013");
        book.setTitle("The Messenger");
        book.setPrice("12.44");

        book = bookRepository.save(book);

        Optional<Book> foundBook = bookRepository.findById(book.getBookId());

        assertEquals(foundBook.get(), book);
    }

    @Test
    public void shouldGetAllBooks() {
        Author author = new Author();
        author.setFirstName("J.K.");
        author.setLastName("Rowling");
        author.setStreet("232 Maple St");
        author.setCity("New York City");
        author.setState("New York");
        author.setPostalCode("92422");
        author.setPhone("859-429-3920");
        author.setEmail("jkRowling@gmail.com");
        author = authorRepository.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("J.K. Rowling Publishing");
        publisher.setStreet("232 Maple St");
        publisher.setCity("New York City");
        publisher.setState("New York");
        publisher.setPostalCode("92422");
        publisher.setPhone("859-429-3920");
        publisher.setEmail("jkRowling@gmail.com");
        publisher = publisherRepository.save(publisher);

        Book book = new Book();
        book.setPublisherId(publisher.getId());
        book.setAuthorId(author.getAuthorId());
        book.setIsbn("38309302");
        book.setPublishDate("03-23-2013");
        book.setTitle("The Messenger");
        book.setPrice("12.44");

        book = bookRepository.save(book);

        book = new Book();
        book.setPublisherId(publisher.getId());
        book.setAuthorId(author.getAuthorId());
        book.setIsbn("392749");
        book.setPublishDate("04-2-2012");
        book.setTitle("The Receiver");
        book.setPrice("23.42");

        book = bookRepository.save(book);

        List<Book> bookList = bookRepository.findAll();

        assertEquals(bookList.size(), 2);
    }

    @Test
    public void shouldUpdateBook() {
        Author author = new Author();
        author.setFirstName("J.K.");
        author.setLastName("Rowling");
        author.setStreet("232 Maple St");
        author.setCity("New York City");
        author.setState("New York");
        author.setPostalCode("92422");
        author.setPhone("859-429-3920");
        author.setEmail("jkRowling@gmail.com");
        author = authorRepository.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("J.K. Rowling Publishing");
        publisher.setStreet("232 Maple St");
        publisher.setCity("New York City");
        publisher.setState("New York");
        publisher.setPostalCode("92422");
        publisher.setPhone("859-429-3920");
        publisher.setEmail("jkRowling@gmail.com");
        publisher = publisherRepository.save(publisher);

        Book book = new Book();
        book.setPublisherId(publisher.getId());
        book.setAuthorId(author.getAuthorId());
        book.setIsbn("38309302");
        book.setPublishDate("03-23-2013");
        book.setTitle("The Messenger");
        book.setPrice("12.44");

        book = bookRepository.save(book);

        book.setIsbn("392749");
        book.setPublishDate("04-2-2012");
        book.setTitle("The Receiver");
        book.setPrice("23.42");

        bookRepository.save(book);

        Optional<Book> book1 = bookRepository.findById(book.getBookId());

        assertEquals(book1.get(), book);
    }

    @Test
    public void shouldDeleteBook() {
        Author author = new Author();
        author.setFirstName("J.K.");
        author.setLastName("Rowling");
        author.setStreet("232 Maple St");
        author.setCity("New York City");
        author.setState("New York");
        author.setPostalCode("92422");
        author.setPhone("859-429-3920");
        author.setEmail("jkRowling@gmail.com");
        author = authorRepository.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("J.K. Rowling Publishing");
        publisher.setStreet("232 Maple St");
        publisher.setCity("New York City");
        publisher.setState("New York");
        publisher.setPostalCode("92422");
        publisher.setPhone("859-429-3920");
        publisher.setEmail("jkRowling@gmail.com");
        publisher = publisherRepository.save(publisher);

        Book book = new Book();
        book.setPublisherId(publisher.getId());
        book.setAuthorId(author.getAuthorId());
        book.setIsbn("38309302");
        book.setPublishDate("03-23-2013");
        book.setTitle("The Messenger");
        book.setPrice("12.44");

        book = bookRepository.save(book);

        bookRepository.delete(book);

        Optional<Book> book1 = bookRepository.findById(book.getBookId());

        assertFalse(book1.isPresent());
    }

    @Test
    public void shouldGetBookByAuthorId() {
        Author author = new Author();
        author.setFirstName("J.K.");
        author.setLastName("Rowling");
        author.setStreet("232 Maple St");
        author.setCity("New York City");
        author.setState("New York");
        author.setPostalCode("92422");
        author.setPhone("859-429-3920");
        author.setEmail("jkRowling@gmail.com");
        author = authorRepository.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("J.K. Rowling Publishing");
        publisher.setStreet("232 Maple St");
        publisher.setCity("New York City");
        publisher.setState("New York");
        publisher.setPostalCode("92422");
        publisher.setPhone("859-429-3920");
        publisher.setEmail("jkRowling@gmail.com");
        publisher = publisherRepository.save(publisher);

        Book book = new Book();
        book.setPublisherId(publisher.getId());
        book.setAuthorId(author.getAuthorId());
        book.setIsbn("38309302");
        book.setPublishDate("03-23-2013");
        book.setTitle("The Messenger");
        book.setPrice("12.44");

        book = bookRepository.save(book);

        Book foundBook = bookRepository.findByAuthorId(book.getAuthorId());

        assertEquals(foundBook, book);
    }

}
