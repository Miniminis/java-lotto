package step02.util;

public class Parser {

    public static int parseStringToInt(String str) {
        int result = 0;
        try {
            result = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_TYPE);
        }

        return result;
    }
}
