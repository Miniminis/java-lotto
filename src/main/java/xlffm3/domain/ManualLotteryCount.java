package xlffm3.domain;

import xlffm3.utils.CommonValue;
import xlffm3.utils.ErrorMessage;

import java.util.Objects;

public class ManualLotteryCount {

    private final int manualLotteryCount;

    public ManualLotteryCount(int manualLotteryCount, PurchasePrice purchasePrice) {
        validate(manualLotteryCount, purchasePrice);
        this.manualLotteryCount = manualLotteryCount;
    }

    private static void validate(int manualLotteryCount, PurchasePrice purchasePrice) {
        if (manualLotteryCount < CommonValue.ZERO) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ENOUGH_MANUAL_COUNT);
        }

        if (!purchasePrice.isWithinBudget(manualLotteryCount * PurchasePrice.LOTTERY_TICKET_PRICE)) {
            throw new IllegalArgumentException(ErrorMessage.OVER_BUDGET);
        }
    }

    public boolean isBiggerThan(int number) {
        return manualLotteryCount > number;
    }

    public int getCount() {
        return this.manualLotteryCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManualLotteryCount that = (ManualLotteryCount) o;
        return manualLotteryCount == that.manualLotteryCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(manualLotteryCount);
    }

}
