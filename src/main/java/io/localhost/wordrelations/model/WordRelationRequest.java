package io.localhost.wordrelations.model;

import jakarta.validation.constraints.NotBlank;

public class WordRelationRequest {

    @NotBlank(message = "firstWord is mandatory")
    private String firstWord;
    @NotBlank(message = "secondWord is mandatory")
    private String secondWord;
    @NotBlank(message = "relation is mandatory")
    private String relation;

    public String getFirstWord() {
        return firstWord;
    }

    public String getSecondWord() {
        return secondWord;
    }

    public String getRelation() {
        return relation;
    }
}
