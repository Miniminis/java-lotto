package xlffm3.domain;

import xlffm3.utils.CommonValue;
import xlffm3.utils.ErrorMessage;

import java.util.Objects;

public class PurchasePrice {

    public static final long LOTTERY_TICKET_PRICE = 1000;

    private final long purchasePrice;

    public PurchasePrice(long purchasePrice) {
        validatePurchasePrice(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    private void validatePurchasePrice(long purchasePrice) {
        if (purchasePrice < LOTTERY_TICKET_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ENOUGH_BUDGET);
        }

        if (purchasePrice % LOTTERY_TICKET_PRICE != CommonValue.ZERO) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY);
        }
    }

    public boolean isWithinBudget(long manualTicketPrice) {
        return manualTicketPrice <= purchasePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchasePrice that = (PurchasePrice) o;
        return purchasePrice == that.purchasePrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchasePrice);
    }
}
