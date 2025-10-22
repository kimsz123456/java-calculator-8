package calculator;

import java.util.*;

public class DelimiterExtractor {
    private static final Set<Character> DEFAULT_DELIMITERS = Set.of(',', ':');

    public ExtractResult extract(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            int separatorLength = 2;

            if (delimiterEndIndex == -1) {
                delimiterEndIndex = input.indexOf("\n");
                separatorLength = 1;
            }

            // 형식 검증
            if (delimiterEndIndex == -1 || delimiterEndIndex <= 2) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
            }

            String customDelimiterStr = input.substring(2, delimiterEndIndex);

            // 1글자가 아니면 예외
            if (customDelimiterStr.length() != 1) {
                throw new IllegalArgumentException("커스텀 구분자는 1글자여야 합니다.");
            }

            char customDelimiter = customDelimiterStr.charAt(0);
            String string = input.substring(delimiterEndIndex + separatorLength);

            Set<Character> allDelimiters = new HashSet<>(DEFAULT_DELIMITERS);
            allDelimiters.add(customDelimiter);

            return new ExtractResult(allDelimiters, string);
        }
        return new ExtractResult(DEFAULT_DELIMITERS, input);
    }
}