package com.app.labforward.challenge.payload.requests;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Data
public class WordFrequencyRequest {

    @NotNull(message = "Search word cannot be blank")
    private String searchWord;
    @NotNull(message = "Notebook word cannot be blank")
    private String notebookWord;
}
