package xlffm3.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import xlffm3.utils.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchasePriceTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 500, 900})
    void create_not_enough_money(long money) {
        assertThatThrownBy(() -> new PurchasePrice(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_ENOUGH_BUDGET);
    }

    @ParameterizedTest
    @ValueSource(ints = {1100, 1400, 2500})
    void create_invalid_money(long money) {
        assertThatThrownBy(() -> new PurchasePrice(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_MONEY);
    }

    @Test
    void create() {
        PurchasePrice purchasePrice = new PurchasePrice(14000);
        assertThat(purchasePrice).isEqualTo(new PurchasePrice(14000));
    }

}
