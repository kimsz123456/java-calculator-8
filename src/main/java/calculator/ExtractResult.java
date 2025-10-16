package calculator;

import java.util.*;

public class ExtractResult {
    private final Set<Character> delimiters;
    private final String string;

    public ExtractResult(Set<Character> delimiters, String string) {
        this.delimiters = delimiters;
        this.string = string;
    }

    public Set<Character> getDelimiters() {
        return delimiters;
    }

    public String getString() {
        return string;
    }
}
