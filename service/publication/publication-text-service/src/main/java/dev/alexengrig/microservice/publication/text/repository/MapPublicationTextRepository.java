package dev.alexengrig.microservice.publication.text.repository;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MapPublicationTextRepository implements PublicationTextRepository {

    private final Map<UUID, String> store = new ConcurrentHashMap<>();

    @Override
    public UUID save(String text) {
        UUID key = UUID.randomUUID();
        store.put(key, text);
        return key;
    }

    @Override
    public Optional<String> findById(UUID textId) {
        return Optional.ofNullable(store.get(textId));
    }

}
