package dev.alexengrig.microservice.publication.text.service;

import dev.alexengrig.microservice.publication.text.client.CensoringTextClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class MapPublicationTextService implements PublicationTextService {

    private final CensoringTextClient censoringClient;

    private final Map<UUID, String> store = new ConcurrentHashMap<>();

    @Override
    public UUID publish(String text) {
        censoringClient.censor(text);
        UUID key = UUID.randomUUID();
        store.put(key, text);
        log.info("Published text by key '{}': '{}'", key, text);
        return key;
    }

}
