package calculator;

import java.util.*;
import java.util.regex.Pattern;

public class StringCalculator {
    private final DelimiterExtractor extractor;
    private final StringParser parser;

    public StringCalculator() {
        this.extractor = new DelimiterExtractor();
        this.parser = new StringParser();
    }

    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        ExtractResult result = extractor.extract(input);
        String[] extractedNumbers = parser.parse(result.getString(), result.getDelimiters());

        return sum(extractedNumbers);
    }

    private int sum(String[] numbers) {
        long sum = 0;
        for (String number : numbers) {
            if (number.isEmpty()) {
                continue;
            }
            if (!number.matches("\\d+")) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + number);
            }
            try {
                sum += Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("입력 숫자가 정수 범위를 초과했습니다: " + number);
            }
            if (sum > Integer.MAX_VALUE) {
                throw new IllegalArgumentException("합계가 정수 범위를 초과했습니다.");
            }
        }
        return (int) sum;
    }
}