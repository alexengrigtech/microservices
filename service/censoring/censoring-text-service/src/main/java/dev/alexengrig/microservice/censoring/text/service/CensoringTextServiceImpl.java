package dev.alexengrig.microservice.censoring.text.service;

import dev.alexengrig.microservice.censoring.text.validator.TextValidationException;
import dev.alexengrig.microservice.censoring.text.validator.TextValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CensoringTextServiceImpl implements CensoringTextService {

    private final List<TextValidator> validators;

    @Override
    public void censor(String text) {
        List<String> messages = new ArrayList<>(validators.size());
        for (TextValidator validator : validators) {
            try {
                validator.validate(text);
            } catch (TextValidationException e) {
                messages.add(e.getMessage());
            }
        }
        if (!messages.isEmpty()) {
            throw new CensoringTextException(messages);
        }
    }

}
