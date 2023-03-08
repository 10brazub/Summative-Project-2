package com.company.bookstore.controller;

import com.company.bookstore.model.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BookController bookController;

    ObjectMapper objectMapper = new ObjectMapper();

    List<Book> bookList;

    @Test
    public void shouldReturnCreatedStatus() throws Exception{

        Book book = new Book();
        book.setIsbn("38309302");
        book.setPublishDate("03-23-2013");
        book.setTitle("The Messenger");
        book.setPrice("12.44");

        String inputJson = objectMapper.writeValueAsString(book);

        mockMvc.perform(
                        post("/book")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldReturnOkStatus() throws Exception{
        Book inputBook = new Book();
        inputBook.setBookId(0);
        inputBook.setIsbn("38309302");
        inputBook.setPublishDate("03-23-2013");
        inputBook.setTitle("The Messenger");
        inputBook.setPrice("12.44");

        String inputJson = objectMapper.writeValueAsString(inputBook);

        mockMvc.perform(
                        get("/book/0")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void shouldReturnOkStatusOnReadAll() throws Exception{

        String outputJson = objectMapper.writeValueAsString(bookList);

        mockMvc.perform(
                get("/book"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void shouldReturnNoContentStatusOnUpdate() throws Exception{
        Book book = new Book();
        book.setIsbn("38309302");
        book.setPublishDate("03-23-2013");
        book.setTitle("The Messenger");
        book.setPrice("12.44");

        String inputJson = objectMapper.writeValueAsString(book);

        mockMvc.perform(
                        put("/book")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldReturnNoContentStatusOnDelete() throws Exception{
        Book book = new Book();
        book.setIsbn("38309302");
        book.setPublishDate("03-23-2013");
        book.setTitle("The Messenger");
        book.setPrice("12.44");

        String inputJson = objectMapper.writeValueAsString(book);

        mockMvc.perform(
                        delete("/book")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldReturnOkStatusOnReadByAuthorId() throws Exception{
        Book inputBook = new Book();
        inputBook.setIsbn("38309302");
        inputBook.setPublishDate("03-23-2013");
        inputBook.setTitle("The Messenger");
        inputBook.setPrice("12.44");
        inputBook.setAuthorId(2);

        String inputJson = objectMapper.writeValueAsString(inputBook);

        mockMvc.perform(
                        get("/book/author/2")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }


}
