package dev.alexengrig.microservice.censoring.text.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CensoringTextServiceImpl implements CensoringTextService {

    private final List<TextCensor> censors;

    @Override
    public void censor(String text) {
        for (TextCensor censor : censors) {
            try {
                censor.check(text);
            } catch (Exception e) {
                log.info("Censored text by '{}': '{}'", e.getMessage(), text);
                throw e;
            }
        }
    }

}
