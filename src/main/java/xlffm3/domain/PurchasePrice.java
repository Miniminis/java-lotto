package xlffm3.domain;

import xlffm3.utils.CommonValue;

import java.util.Objects;

public class PurchasePrice {

    private static final int MINIMUM_PRICE = 1000;

    private final long purchasePrice;

    private PurchasePrice(long purchasePrice) {
        validatePurchasePrice(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    public static PurchasePrice of(long purchasePrice) {
        return new PurchasePrice(purchasePrice);
    }

    private void validatePurchasePrice(long purchasePrice) {
        if (purchasePrice < MINIMUM_PRICE) {
            throw new IllegalArgumentException();
        }

        if (purchasePrice % MINIMUM_PRICE != CommonValue.ZERO) {
            throw new IllegalArgumentException();
        }
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
