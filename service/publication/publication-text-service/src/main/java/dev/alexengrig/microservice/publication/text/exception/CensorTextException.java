package dev.alexengrig.microservice.publication.text.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Censor")
public class CensorTextException extends RuntimeException {

    public CensorTextException(String message) {
        System.out.println("Censor: " + message);
    }

}
