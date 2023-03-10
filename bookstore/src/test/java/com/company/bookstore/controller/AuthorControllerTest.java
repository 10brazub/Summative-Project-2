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

    // Create an instance of the ObjectMapper to convert objects to JSON
    private ObjectMapper mapper = new ObjectMapper();

    // Test to retrieve all Authors from the repository
    @Test
    public void testReadAllAuthor() throws Exception {
        mockMvc.perform(get("/author"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Test to retrieve an Author from the repository by ID
    @Test
    public void testReadAuthorById() throws Exception {
        Author author = new Author();
        author.setEmail("pkd@gmail.com");
        author.setPhone("849-242-1412");
        author.setFirstName("Philip");
        author.setLastName("Dick");
        author.setStreet("1312 Hopkins Ave");
        author.setPostalCode("60601");
        author.setState("Illinois");
        author.setCity("Chicago");
        author.setAuthorId(2);

        // Convert the Author object to JSON
        String inputJson = mapper.writeValueAsString(author);

        // Perform the GET request to retrieve the Author by ID
        mockMvc.perform(
                    get("/author/2")
                            .content(inputJson)
                            .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Test to create a new Author in the repository
    @Test
    public void testCreateAuthor() throws Exception {

        // Create a sample Author object to add to the repository
        Author author = new Author();
        author.setEmail("pkd@gmail.com");
        author.setPhone("849-242-1412");
        author.setFirstName("Philip");
        author.setLastName("Dick");
        author.setStreet("1312 Hopkins Ave");
        author.setPostalCode("60601");
        author.setState("Illinois");
        author.setCity("Chicago");
        author.setAuthorId(2);

        // Convert the Author object to JSON
        String inputJson = mapper.writeValueAsString(author);

        // Perform the POST request to add the Author to the repository
        mockMvc.perform(
                        post("/author")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }

    // Test to update an existing Author in the repository
    @Test
    public void testUpdateAuthor() throws Exception {

        // Create a sample Author object to update in the repository
        Author author = new Author();
        author.setEmail("pkd@gmail.com");
        author.setPhone("849-242-1412");
        author.setFirstName("Philip");
        author.setLastName("Dick");
        author.setStreet("1312 Hopkins Ave");
        author.setPostalCode("60601");
        author.setState("Illinois");
        author.setCity("Chicago");
        author.setAuthorId(2);

        // Convert the Author object to JSON
        String inputJson = mapper.writeValueAsString(author);

        // Perform the PUT request to update the Author in the repository
        mockMvc.perform(put("/author")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // Test to delete an Author from the repository by ID
    @Test
    public void testDeleteAuthorById() throws Exception {

        // Perform the DELETE request to remove the Author from the repository by ID
        mockMvc.perform(delete("/author/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}