package calculator;

import java.util.*;

public class DelimiterExtractor {
    private static final Set<Character> DEFAULT_DELIMITERS = Set.of(',', ':');

    public ExtractResult extract(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            char customDelimiter = input.charAt(2);
            String numbers = input.substring(delimiterEndIndex + 1);

            Set<Character> allDelimiters = new HashSet<>(DEFAULT_DELIMITERS);
            allDelimiters.add(customDelimiter);

            return new ExtractResult(allDelimiters, numbers);
        }
        return new ExtractResult(DEFAULT_DELIMITERS, input);
    }
}