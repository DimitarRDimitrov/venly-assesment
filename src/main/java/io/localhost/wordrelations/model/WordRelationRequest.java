package io.localhost.wordrelations.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.localhost.wordrelations.converter.ToTrimmedLowerCaseConverter;
import jakarta.validation.constraints.NotBlank;

public class WordRelationRequest {

    @NotBlank(message = "firstWord is mandatory")
    @JsonDeserialize(converter = ToTrimmedLowerCaseConverter.class)
    private String firstWord;
    @NotBlank(message = "secondWord is mandatory")
    @JsonDeserialize(converter = ToTrimmedLowerCaseConverter.class)
    private String secondWord;
    @NotBlank(message = "relation is mandatory")
    @JsonDeserialize(converter = ToTrimmedLowerCaseConverter.class)
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
