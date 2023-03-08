package com.company.bookstore.controller;

import com.company.bookstore.model.Author;
import com.company.bookstore.repository.AuthorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthorController.class)

public class AuthorControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    AuthorRepository authorRepository;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testReadAllAuthor() throws Exception {
        mockMvc.perform(get("/author"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void testReadAuthorById() throws Exception {
        Author author = new Author();
        author.setEmail("email@email.com");
        author.setPhone("000-000-0000");
        author.setFirstName("Name");
        author.setLastName("Last");
        author.setStreet("Street");
        author.setPostalCode("99999");
        author.setState("St");
        author.setCity("City");
        author.setAuthorId(2);
        String outputJson = mapper.writeValueAsString(author);
        mockMvc.perform(get("/author/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateAuthor() throws Exception {
        Author author = new Author();
        author.setEmail("email@email.com");
        author.setPhone("000-000-0000");
        author.setFirstName("Name");
        author.setLastName("Last");
        author.setStreet("Street");
        author.setPostalCode("99999");
        author.setState("St");
        author.setCity("City");
        author.setAuthorId(2);
        String inputJson = mapper.writeValueAsString(author);

        mockMvc.perform(
                        post("/author")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateAuthor() throws Exception {
        Author author = new Author();
        author.setEmail("email@email.com");
        author.setPhone("000-000-0000");
        author.setFirstName("Name");
        author.setLastName("Last");
        author.setStreet("Street");
        author.setPostalCode("99999");
        author.setState("St");
        author.setCity("City");
        author.setAuthorId(2);
        String inputJson = mapper.writeValueAsString(author);


        mockMvc.perform(put("/author")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void testDeleteAuthorById() throws Exception {
        mockMvc.perform(delete("/author/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}