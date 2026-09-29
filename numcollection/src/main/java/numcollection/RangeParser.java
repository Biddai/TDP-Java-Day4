package numcollection;

import java.util.ArrayList;
import java.util.List;

// Parse sorted, non-overlapping inclusive ranges without expanding their values.
public final class RangeParser {
    private RangeParser() {
    }

    public static List<Range> parse(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Empty input");
        }
        List<Range> ranges = new ArrayList<>();
        // Keep empty tokens so inputs such as "1,,3" are rejected.
        String[] tokens = input.split(",", -1);
        for (String token : tokens) {
            String text = token.trim();
            // A minus sign at position zero belongs to the first number.
            int separator = text.indexOf('-', 1);
            int start;
            int end;
            if (separator < 0) {
                start = parseNumber(text);
                end = start;
            } else {
                start = parseNumber(text.substring(0, separator).trim());
                if(text.charAt(separator+1)=='-')
                {
                    separator++;
                }
                end = parseNumber(text.substring(separator + 1).trim());
            }
            if (start > end) {
                throw new IllegalArgumentException("Reversed range");
            }
            if (!ranges.isEmpty()) {
                Range previous = ranges.get(ranges.size() - 1);
                if (start <= previous.getEnd()) {
                    throw new UnsortedValuesException("Ranges must be sorted and non-overlapping");
                }
            }
            ranges.add(new Range(start, end));
        }
        return ranges;
    }

    private static int parseNumber(String text) {
        if (text.isEmpty() || text.equals("-")) {
            throw new IllegalArgumentException("Missing number");
        }
        int firstDigit = 0;
        if (text.charAt(0) == '-') {
            firstDigit = 1;
        }
        for (int index = firstDigit; index < text.length(); index++) {
            char character = text.charAt(index);
            if (character < '0' || character > '9') {
                throw new IllegalArgumentException("Invalid number: " + text);
            }
        }
        return Integer.parseInt(text);
    }
}
