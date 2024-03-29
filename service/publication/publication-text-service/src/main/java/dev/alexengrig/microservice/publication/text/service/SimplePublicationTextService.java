package dev.alexengrig.microservice.publication.text.service;

import dev.alexengrig.microservice.publication.text.client.CensoringTextClient;
import dev.alexengrig.microservice.publication.text.repository.PublicationTextRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class SimplePublicationTextService implements PublicationTextService {

    private final PublicationTextRepository repository;
    private final CensoringTextClient censoringClient;

    @Override
    public UUID publish(String text) {
        ResponseEntity<String> censoringResponse = censoringClient.censor(text);
        if (censoringResponse.getStatusCode() != HttpStatus.OK) {
            throw new CensoredTextException(censoringResponse.getBody());
        }
        UUID textId = repository.save(text);
        log.info("Published text by id '{}': '{}'", textId, text);
        return textId;
    }

    @Override
    public Optional<String> get(UUID textId) {
        return repository.findById(textId);
    }

}
