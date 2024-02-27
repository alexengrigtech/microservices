package dev.alexengrig.microservice.censoring.text.service;

import java.util.List;

public class CensoringTextException extends RuntimeException {

    public CensoringTextException(List<String> messages) {
        super(String.join("\n", messages));
    }

}
