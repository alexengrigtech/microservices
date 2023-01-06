package dev.alexengrig.microservice.censoring.text.service;

import dev.alexengrig.microservice.censoring.text.config.props.CensoringTextProps;
import dev.alexengrig.microservice.censoring.text.exception.IllegalWordTextCensorException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class BlacklistTextCensor implements TextCensor {

    private final CensoringTextProps props;

    @Override
    public void check(String text) {
        boolean hasIllegalWord = Arrays.stream(text.toLowerCase().split("\\W+"))
                .anyMatch(props.getBlacklist()::contains);
        if (hasIllegalWord) {
            throw new IllegalWordTextCensorException();
        }
    }

}
