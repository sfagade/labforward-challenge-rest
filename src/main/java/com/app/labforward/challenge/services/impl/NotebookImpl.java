package com.app.labforward.challenge.services.impl;

import com.app.labforward.challenge.exceptions.CustomValidationException;
import com.app.labforward.challenge.services.NotebookService;
import org.springframework.stereotype.Service;

@Service
public class NotebookImpl implements NotebookService {


    @Override
    public Integer calculateWordFrequency(String word, String notebookText) {

        if (word == null || word.trim().isEmpty() || notebookText == null || notebookText.trim().isEmpty()) {
            throw new CustomValidationException(400, "Validation failed");
        }

        String[] notebookWords = notebookText.split(" ");
        int count = 0;

        for (String noteWord : notebookWords) {
            if (word.equals(noteWord)) {
                count++;
            }
        }

        return count;
    }
}
