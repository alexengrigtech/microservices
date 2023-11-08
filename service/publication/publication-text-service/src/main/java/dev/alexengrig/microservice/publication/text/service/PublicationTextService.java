package dev.alexengrig.microservice.publication.text.service;

import java.util.Optional;
import java.util.UUID;

public interface PublicationTextService {

    UUID publish(String text);

    Optional<String> get(UUID textId);

}
