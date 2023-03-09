package com.company.bookstore.controller;

import com.company.bookstore.model.Publisher;
import com.company.bookstore.repository.PublisherRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@RunWith(SpringRunner.class)
@WebMvcTest(PublisherController.class)
public class PublisherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PublisherRepository PublisherRepository;


    private ObjectMapper mapper = new ObjectMapper();


    private List<Publisher> publisherList;


    @Test
    public void shouldReturnNewPublisherOnPostRequest() throws Exception {

        Publisher inputPublisher = new Publisher();
        inputPublisher.setName("Name");
        inputPublisher.setStreet("street");
        inputPublisher.setCity("City");
        inputPublisher.setState("State");
        inputPublisher.setPostalCode("00000");
        inputPublisher.setPhone("000-000-0000");
        inputPublisher.setEmail("email@email.com");

        String inputJson = mapper.writeValueAsString(inputPublisher);

        Publisher outputPublisher = new Publisher();
        inputPublisher.setName("Name");
        inputPublisher.setStreet("street");
        inputPublisher.setCity("City");
        inputPublisher.setState("State");
        inputPublisher.setPostalCode("00000");
        inputPublisher.setPhone("000-000-0000");
        inputPublisher.setEmail("email@email.com");

        String outputJson = mapper.writeValueAsString(outputPublisher);

        mockMvc.perform(
                        post("/publisher")                            // Perform the POST request
                                .content(inputJson)                       // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
                )
                .andDo(print())                                // Print results to console
                .andExpect(status().isCreated());              // ASSERT (status code is 201)
    }

    @Test
    public void shouldUpdateByIdAndReturn204StatusCode() throws Exception {

        Publisher inputPublisher = new Publisher();
        inputPublisher.setName("Name");
        inputPublisher.setStreet("street");
        inputPublisher.setCity("City");
        inputPublisher.setState("State");
        inputPublisher.setPostalCode("00000");
        inputPublisher.setPhone("000-000-0000");
        inputPublisher.setEmail("email@email.com");
        String inputJson = mapper.writeValueAsString(inputPublisher);

        mockMvc.perform(
                        put("/publisher")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteByIdAndReturn204StatusCode() throws Exception {

        mockMvc.perform(delete("/publisher/5"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }


    @Test
    public void shouldReturnPublisherById() throws Exception {
        Publisher inputPublisher = new Publisher();
        inputPublisher.setName("Name");
        inputPublisher.setStreet("street");
        inputPublisher.setCity("City");
        inputPublisher.setState("State");
        inputPublisher.setPostalCode("00000");
        inputPublisher.setPhone("000-000-0000");
        inputPublisher.setEmail("email@email.com");
        inputPublisher.setId(2);

        String outputJson = mapper.writeValueAsString(inputPublisher);

        mockMvc.perform(get("/publisher/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnAllPublishers() throws Exception {

        String outputJson = mapper.writeValueAsString(publisherList);

        mockMvc.perform(get("/publisher"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
