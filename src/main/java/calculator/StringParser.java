package calculator;

import java.util.*;
import java.util.regex.Pattern;

public class StringParser {
    public String[] parse(String input, Set<Character> delimiters) {
        String regex = createRegex(delimiters);
        return Arrays.stream(input.split(regex, -1))
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);
    }

    private String createRegex(Set<Character> delimiters) {
        StringBuilder pattern = new StringBuilder("[");
        for (char delimiter : delimiters) {
            pattern.append(Pattern.quote(String.valueOf(delimiter)));
        }
        pattern.append("]");
        return pattern.toString();
    }
}
