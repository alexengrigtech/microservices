package dev.alexengrig.microservice.censoring.text.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal Word")
public class IllegalWordTextCensorException extends RuntimeException {

    public IllegalWordTextCensorException() {
        super("Text has an illegal word!");
    }

}
