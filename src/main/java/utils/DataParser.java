package utils;

public class DataParser {

    public static int parseToInt(String stringNumber) {
        if (stringNumber == null || stringNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }

        int parsed = Integer.parseInt(stringNumber);

        if (parsed < 0) {
            throw new NumberFormatException("음수는 계산할 수 없습니다.");
        }

        return parsed;
    }

}
