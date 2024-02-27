package dev.alexengrig.microservice.censoring.text.validator;

import dev.alexengrig.microservice.censoring.text.config.props.CensoringTextProps;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlacklistTextValidator implements TextValidator {

    private final CensoringTextProps props;

    @Override
    public void validate(String text) throws TextValidationException {
        Set<String> illegalWords = Arrays.stream(text.toLowerCase().split("\\W+"))
                .filter(props.getBlacklist()::contains)
                .collect(Collectors.toSet());
        if (!illegalWords.isEmpty()) {
            throw new TextValidationException("Text has illegal words: " + illegalWords);
        }
    }

}
