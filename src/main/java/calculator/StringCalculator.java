package calculator;

import java.util.*;
import java.util.regex.Pattern;

public class StringCalculator {
    private final DelimiterExtractor extractor;

    public StringCalculator() {
        this.extractor = new DelimiterExtractor();
    }

    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        ExtractResult result = extractor.extract(input);
        Set<Character> delimiters = result.getDelimiters();
        String string = result.getString();

        String[] extractedNumbers = extractNumbers(string, delimiters);

        return sum(extractedNumbers);
    }

    private String[] extractNumbers(String string, Set<Character> delimiters) {
        String regex = createRegex(delimiters);
        return string.split(regex);
    }

    private String createRegex(Set<Character> delimiters) {
        StringBuilder pattern = new StringBuilder("[");
        for (char delimiter : delimiters) {
            pattern.append(Pattern.quote(String.valueOf(delimiter)));
        }
        pattern.append("]");
        return pattern.toString();
    }

    private int sum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            if (!number.isEmpty()) {
                sum += parseNumber(number);
            }
        }
        return sum;
    }

    private int parseNumber(String number) {
        return Integer.parseInt(number.trim());
    }
}
