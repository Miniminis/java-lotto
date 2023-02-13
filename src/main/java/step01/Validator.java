package step01;

public class Validator {

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isOneNumber(String str) {
        return isNumber(str) && str.length() == 1;
    }

    private static boolean isNumber(String numberStr) {
        try {
            Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isNumberType(String[] numbers) {
        for (String s : numbers) {
            if (!isNumber(s)) return false;
        }
        return true;
    }

    public static boolean isMinusNumber(String[] numbers) {
        for (String s : numbers) {
            if (Integer.parseInt(s) < 0) return true;
        }
        return false;
    }
}
