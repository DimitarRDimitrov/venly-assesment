package io.localhost.wordrelations.config.converter;

import com.fasterxml.jackson.databind.util.StdConverter;

public class ToTrimmedLowerCaseConverter extends StdConverter<String, String> {

    @Override
    public String convert(String value) {
        return value.toLowerCase().trim();
    }
}
