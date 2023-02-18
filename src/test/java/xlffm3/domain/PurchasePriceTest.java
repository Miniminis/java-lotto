package xlffm3.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchasePriceTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 500, 1400})
    void create_invalid(long money) {
        assertThatThrownBy(() -> PurchasePrice.of(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void create() {
        PurchasePrice purchasePrice = PurchasePrice.of(14000);
        assertThat(purchasePrice).isEqualTo(PurchasePrice.of(14000));
    }


}
