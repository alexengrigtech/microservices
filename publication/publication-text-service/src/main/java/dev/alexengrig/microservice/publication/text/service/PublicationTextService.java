package dev.alexengrig.microservice.publication.text.service;

import java.util.UUID;

public interface PublicationTextService {

    UUID publish(String text);

}
