package com.app.labforward.challenge.services.impl;

import com.app.labforward.challenge.exceptions.CustomValidationException;
import com.app.labforward.challenge.services.NotebookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NotebookImplTest {

    @Autowired
    private NotebookService notebookService;

    @Test
    void calculateWordFrequencyDefaultState() {

        Integer frequency = this.notebookService.calculateWordFrequency("Word", "Word Words wor word");

        assertAll(
                "Calculate Word Default Test",
                () -> assertNotNull(frequency, "Frequency failed with null"),
                () -> assertEquals(frequency, 1, "Frequency not equal expected 1"));
    }

    @Test
    void calculateWordFrequencyNoWord() {
        RuntimeException customValidationException = assertThrows(CustomValidationException.class, () ->
                notebookService.calculateWordFrequency(null, "Word Words wor word"));
        assertTrue(customValidationException.getMessage().equalsIgnoreCase("Validation failed")
                , "Result wrong when word not passed");
    }

    @Test
    void calculateWordFrequencyNoNotebook() {
        RuntimeException customValidationException = assertThrows(CustomValidationException.class, () ->
                notebookService.calculateWordFrequency("Word", " "));
        assertTrue(customValidationException.getMessage().equalsIgnoreCase("Validation failed")
                , "Result wrong when notebook not passed");
    }

    @Test
    void calculateWordFrequencyNoMatch() {
        Integer frequency = this.notebookService.calculateWordFrequency("Word", "Wod Words wor word");

        assertAll(
                "Calculate Word No Match Test",
                () -> assertNotNull(frequency, "Frequency failed with null"),
                () -> assertEquals(frequency, 0, "Frequency not equal expected 0"));
    }

    @Test
    void calculateWordFrequencyGreaterThanOneFrequency() {
        Integer frequency = this.notebookService.calculateWordFrequency("Word", "Word Word Word word");

        assertAll(
                "Calculate Word Default Test",
                () -> assertNotNull(frequency, "Frequency failed with null"),
                () -> assertEquals(frequency, 3, "Frequency not equal expected 3"));
    }
}