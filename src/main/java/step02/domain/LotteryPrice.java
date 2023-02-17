package step02.domain;

import step02.util.ErrorMessage;
import step02.util.Parser;
import step02.util.Validator;

public class LotteryPrice {

    private static final int PRICE_UNIT = 1000;

    private final int price;

    public LotteryPrice(String lotteryPriceInput) {
        validateNullOrEmpty(lotteryPriceInput);

        int price = Parser.parseStringToInt(lotteryPriceInput);
        validatePrice(price);

        this.price = price;
    }

    private static void validatePrice(int price) {
        if (price / PRICE_UNIT <= 0) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_RANGE);
        }
    }

    private static void validateNullOrEmpty(String lotteryPriceInput) {
        if (Validator.isNullOrEmpty(lotteryPriceInput)) {
            throw new IllegalArgumentException(ErrorMessage.NULL_OR_EMPTY);
        }
    }

    public int numOrLottery() {
        return price / PRICE_UNIT;
    }

    public int value() {
        return price;
    }
}
