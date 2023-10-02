package dev.alexengrig.microservice.rating.text.service;

import java.util.UUID;

public interface LikingTextService {

    void like(UUID textId);

}
