package com.app.labforward.challenge.controllers;

import com.app.labforward.challenge.exceptions.CustomValidationException;
import com.app.labforward.challenge.payload.requests.WordFrequencyRequest;
import com.app.labforward.challenge.payload.responses.ApplicationResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class NotebookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void checkWordFrequencyDefaultState() throws Exception {
        WordFrequencyRequest wordFrequencyRequest = prepareRequestObject("Word", "Word Words wor word");

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/notebooks")
                .content(new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(wordFrequencyRequest))
                .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk()).andReturn();

        ApplicationResponse applicationResponse = new ObjectMapper().reader()
                .forType(new TypeReference<ApplicationResponse>() {})
                .readValue(result.getResponse().getContentAsString());

        assertAll(
                "Word Frequency API call Default Tests",
                () -> assertNotNull(applicationResponse, "Response is null"),
                () -> assertEquals(applicationResponse.getFrequency(), 1, "Frequency result is wrong"));
    }

    @Test
    void checkWordFrequencyInvalidNotebook() throws Exception {
        WordFrequencyRequest wordFrequencyRequest = prepareRequestObject("Word", null);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/notebooks")
                .content(new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(wordFrequencyRequest))
                .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isBadRequest()).andReturn();
    }

    private WordFrequencyRequest prepareRequestObject(String word, String notebook) {
        WordFrequencyRequest wordFrequencyRequest = new WordFrequencyRequest();
        wordFrequencyRequest.setSearchWord(word);
        wordFrequencyRequest.setNotebookWord(notebook);

        return wordFrequencyRequest;
    }
}