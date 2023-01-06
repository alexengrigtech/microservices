package dev.alexengrig.microservice.rating.text.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class MapLikingTextService implements LikingTextService {

    private final Map<UUID, Long> store = new ConcurrentHashMap<>();

    @Override
    public void like(UUID textId) {
        store.compute(textId, (key, likes) -> {
            long newLikes = likes == null ? 1 : likes + 1;
            log.info("Liked text by key '{}': '{}'", key, newLikes);
            return newLikes;
        });
    }

}
