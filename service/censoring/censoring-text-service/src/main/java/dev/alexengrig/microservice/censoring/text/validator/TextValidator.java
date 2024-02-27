package dev.alexengrig.microservice.censoring.text.validator;

public interface TextValidator {

    void validate(String text) throws TextValidationException;

}
