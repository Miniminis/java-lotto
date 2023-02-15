package step02.domain;

import step02.util.ErrorMessage;

import java.util.Arrays;

public enum LotteryStandard {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final int count;

    private final int amount;

    LotteryStandard(int count, int amount) {
        this.count = count;
        this.amount = amount;
    }

    public int getCount() {
        return count;
    }

    public int getAmount() {
        return amount;
    }

    public static LotteryStandard valueByCount(int count) {
        return Arrays.stream(LotteryStandard.values())
                .filter(lotteryStandard -> lotteryStandard.getCount() == count)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NO_MATCHED_STANDARD));
    }
}
