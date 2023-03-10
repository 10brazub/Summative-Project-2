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

    // Create an instance of the Jackson ObjectMapper
    private ObjectMapper mapper = new ObjectMapper();

    // Define an empty list to hold publisher objects
    private List<Publisher> publisherList;

    @Test
    public void shouldReturnNewPublisher() throws Exception {

        // Create a new instance of the Publisher class and set its properties
        Publisher inputPublisher = new Publisher();
        inputPublisher.setName("Penguin Random House");
        inputPublisher.setStreet("1745 Broadway");
        inputPublisher.setCity("New York City");
        inputPublisher.setState("New York");
        inputPublisher.setPostalCode("10019");
        inputPublisher.setPhone("800-793-2665");
        inputPublisher.setEmail("penguinrandomhouse@gmail.com");

        // Serialize the Publisher object to JSON format
        String inputJson = mapper.writeValueAsString(inputPublisher);

        // Define the expected output Publisher object
        Publisher outputPublisher = new Publisher();
        outputPublisher.setName("Penguin Random House");
        outputPublisher.setStreet("1745 Broadway");
        outputPublisher.setCity("New York City");
        outputPublisher.setState("New York");
        outputPublisher.setPostalCode("10019");
        outputPublisher.setPhone("800-793-2665");
        outputPublisher.setEmail("penguinrandomhouse@gmail.com");

        // Serialize the expected output Publisher object to JSON format
        String outputJson = mapper.writeValueAsString(outputPublisher);

        // Perform a POST request to the "/publisher" endpoint with the serialized input JSON
        mockMvc.perform(
                        post("/publisher")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                // Print the results to the console
                .andDo(print())
                // Assert that the status code of the response is 201 (created)
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldUpdateById() throws Exception {

        // Create a new instance of the Publisher class and set its properties
        Publisher inputPublisher = new Publisher();
        inputPublisher.setName("Penguin Random House");
        inputPublisher.setStreet("1745 Broadway");
        inputPublisher.setCity("New York City");
        inputPublisher.setState("New York");
        inputPublisher.setPostalCode("10019");
        inputPublisher.setPhone("800-793-2665");
        inputPublisher.setEmail("penguinrandomhouse@gmail.com");

        // Serialize the Publisher object to JSON format
        String inputJson = mapper.writeValueAsString(inputPublisher);

        // Perform a PUT request to the "/publisher" endpoint with the serialized input JSON
        mockMvc.perform(
                        put("/publisher")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                // Print the results to the console
                .andDo(print())
                // Assert that the status code of the response is 204 (no content)
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteById() throws Exception {

        // Perform a DELETE request to the "/publisher/5" endpoint
        mockMvc.perform(delete("/publisher/5"))
                // Print the results to the console
                .andDo(print())
                // Assert that the status code of the response is 204 (no content)
                .andExpect(status().isNoContent());
    }


    @Test
    public void shouldReturnPublisherById() throws Exception {
        // Create a new instance of the Publisher class and set its properties
        Publisher inputPublisher = new Publisher();
        inputPublisher.setName("Penguin Random House");
        inputPublisher.setStreet("1745 Broadway");
        inputPublisher.setCity("New York City");
        inputPublisher.setState("New York");
        inputPublisher.setPostalCode("10019");
        inputPublisher.setPhone("800-793-2665");
        inputPublisher.setEmail("penguinrandomhouse@gmail.com");
        inputPublisher.setId(2);

        // Convert the Publisher object to a JSON string
        String outputJson = mapper.writeValueAsString(inputPublisher);

        // Make a GET request to the endpoint with the ID of the Publisher we created
        mockMvc.perform(get("/publisher/2"))
                .andDo(print()) // Print results to console
                .andExpect(status().isOk()); // ASSERT (status code is 200)
    }

    @Test
    public void shouldReturnAllPublishers() throws Exception {
        // Convert the publisherList object to a JSON string
        String outputJson = mapper.writeValueAsString(publisherList);

        // Make a GET request to the endpoint to get all publishers
        mockMvc.perform(get("/publisher"))
                .andDo(print()) // Print results to console
                .andExpect(status().isOk()); // ASSERT (status code is 200)
    }
}
