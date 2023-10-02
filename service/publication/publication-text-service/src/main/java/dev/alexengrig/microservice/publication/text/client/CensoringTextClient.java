package dev.alexengrig.microservice.publication.text.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "censoring-text-service", path = "/api/internal/censoring/texts")
public interface CensoringTextClient {

    @PostMapping
    void censor(@RequestBody String text);

}
