package dev.alexengrig.microservice.publication.text.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class MapPublicationTextService implements PublicationTextService {

    private final Map<UUID, String> store = new ConcurrentHashMap<>();

    @Override
    public UUID publish(String text) {
        UUID key = UUID.randomUUID();
        store.put(key, text);
        log.info("Published text by key '{}': '{}'", key, text);
        return key;
    }

}
