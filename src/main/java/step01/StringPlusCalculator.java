package step01;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPlusCalculator {

    public static int splitAndSum(String input) {
        if (Validator.isNullOrEmpty(input)) {
            return 0;
        }

        if (Validator.isOneNumber(input)) {
            return Integer.parseInt(input);
        }

        Matcher matcher = splitDelimiter(input);
        String[] numbers = splitNumbers(matcher.group(2), matcher.group(1));

        return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
    }

    public static Matcher splitDelimiter(String input) {
        if (!input.startsWith("//")) {
            input = input.replaceAll(",", ":");
            input = "//:\n" + input;
        }
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (!matcher.find()) {
            throw new RuntimeException();
        }
        return matcher;
    }

    private static String[] splitNumbers(String input, String delimiter) {
        String[] numbers = input.split(delimiter);

        if (!Validator.isNumberType(numbers) || Validator.isMinusNumber(numbers)) {
            throw new RuntimeException();
        }
        return numbers;
    }
}
