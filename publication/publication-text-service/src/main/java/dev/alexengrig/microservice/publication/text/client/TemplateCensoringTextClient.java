package dev.alexengrig.microservice.publication.text.client;

import dev.alexengrig.microservice.publication.text.exception.CensorTextException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class TemplateCensoringTextClient implements CensoringTextClient {

    @Value("${service.censoring-text.url}")
    private final String serviceUrl;

    private final RestTemplate template;

    @Override
    public void censor(String text) {
        String url = serviceUrl + "/api/internal/censoring/texts";
        try {
            template.postForObject(url, text, Void.class);
        } catch (HttpStatusCodeException e) {
            throw new CensorTextException(e.getMessage());
        }
    }

}
