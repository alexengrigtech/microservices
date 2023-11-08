package dev.alexengrig.microservice.publication.text.repository;

import java.util.Optional;
import java.util.UUID;

public interface PublicationTextRepository {

    UUID save(String text);

    Optional<String> findById(UUID textId);

}
