package com.company.bookstore.repository;

import com.company.bookstore.model.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Before
    public void setUp() throws Exception {
        bookRepository.deleteAll();
    }

    @Test
    public void shouldAddBook() {
        Book book = new Book();
        book.setIsbn("38309302");
        book.setPublishDate("03-23-2013");
        book.setTitle("The Messenger");
        book.setPrice("12.44");

        bookRepository.save(book);

        Optional<Book> book1 = bookRepository.findById(book.getBookId());

        assertEquals(book1.get(), book);
    }

    @Test
    public void shouldGetBookById () {
        Book book = new Book();
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
        Book book = new Book();
        book.setIsbn("38309302");
        book.setPublishDate("03-23-2013");
        book.setTitle("The Messenger");
        book.setPrice("12.44");

        book = bookRepository.save(book);

        book = new Book();
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
        Book book = new Book();
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
        Book book = new Book();
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
        Book book = new Book();
        book.setIsbn("38309302");
        book.setPublishDate("03-23-2013");
        book.setTitle("The Messenger");
        book.setPrice("12.44");

        book = bookRepository.save(book);

        Book foundBook = bookRepository.findByAuthorId(book.getAuthorId());

        assertEquals(foundBook, book);
    }

}
