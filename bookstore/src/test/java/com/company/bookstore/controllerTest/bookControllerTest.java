package com.company.bookstore.controllerTest;

import com.company.bookstore.controller.BookController;
import com.company.bookstore.model.Book;
import com.company.bookstore.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(BookController.class)
public class bookControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BookController bookController;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void shouldReturnCreatedStatusCode() throws Exception{

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

}
