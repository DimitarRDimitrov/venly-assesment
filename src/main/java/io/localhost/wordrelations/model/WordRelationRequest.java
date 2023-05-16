package io.localhost.wordrelations.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.localhost.wordrelations.config.converter.ToTrimmedLowerCaseConverter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class WordRelationRequest {

    @NotBlank(message = "firstWord is mandatory")
    @JsonDeserialize(converter = ToTrimmedLowerCaseConverter.class)
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "firstWord is invalid.")
    private String firstWord;
    @NotBlank(message = "secondWord is mandatory")
    @JsonDeserialize(converter = ToTrimmedLowerCaseConverter.class)
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "secondWord is invalid.")
    private String secondWord;
    @NotBlank(message = "relation is mandatory")
    @JsonDeserialize(converter = ToTrimmedLowerCaseConverter.class)
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "relation is invalid.")
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
