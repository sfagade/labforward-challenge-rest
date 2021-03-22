package com.app.labforward.challenge.controllers;

import com.app.labforward.challenge.payload.requests.WordFrequencyRequest;
import com.app.labforward.challenge.payload.responses.ApplicationResponse;
import com.app.labforward.challenge.services.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/notebooks")
public class NotebookController {

    private final NotebookService notebookService;

    @Autowired
    public NotebookController(NotebookService notebookService) {
        this.notebookService = notebookService;
    }

    @PostMapping
    public ResponseEntity<ApplicationResponse> checkWordFrequency(
            @Valid @RequestBody WordFrequencyRequest wordFrequencyRequest) {

        ApplicationResponse applicationResponse = new ApplicationResponse();
        applicationResponse.setFrequency(this.notebookService.calculateWordFrequency(wordFrequencyRequest.getSearchWord(),
                wordFrequencyRequest.getNotebookWord()));

        return new ResponseEntity<>(applicationResponse, HttpStatus.OK);
    }
}
