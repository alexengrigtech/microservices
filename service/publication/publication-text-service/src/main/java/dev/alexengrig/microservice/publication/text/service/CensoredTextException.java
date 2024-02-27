package dev.alexengrig.microservice.publication.text.service;

public class CensoredTextException extends RuntimeException {

    public CensoredTextException(String message) {
        super("Censored text:\n" + message);
    }

}
