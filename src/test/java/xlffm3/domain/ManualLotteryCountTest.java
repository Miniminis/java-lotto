package xlffm3.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import xlffm3.utils.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ManualLotteryCountTest {

    @ParameterizedTest
    @CsvSource(value = {"3:10000", "5:5000"}, delimiter = ':')
    void create(int manualCount, long purchasePrice) {
        ManualLotteryCount manualLotteryCount = new ManualLotteryCount(manualCount, new PurchasePrice(purchasePrice));
        assertThat(manualLotteryCount).isEqualTo(new ManualLotteryCount(manualCount, new PurchasePrice(purchasePrice)));
    }

    @ParameterizedTest
    @CsvSource(value = {"3:1000", "5:4000"}, delimiter = ':')
    void createInvalidBudget(int manualCount, long purchasePrice) {
        assertThatThrownBy(() -> new ManualLotteryCount(manualCount, new PurchasePrice(purchasePrice)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.OVER_BUDGET);
    }

    @ParameterizedTest
    @CsvSource(value = {"-1:1000"}, delimiter = ':')
    void createInvalidManualCount(int manualCount, long purchasePrice) {
        assertThatThrownBy(() -> new ManualLotteryCount(manualCount, new PurchasePrice(purchasePrice)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_ENOUGH_MANUAL_COUNT);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:10000:3:false", "5:5000:0:true"}, delimiter = ':')
    void isBiggerThanZero_True(int manualCount, long purchasePrice, int number, boolean expected) {
        ManualLotteryCount manualLotteryCount = new ManualLotteryCount(manualCount, new PurchasePrice(purchasePrice));
        boolean isBiggerThanNumber = manualLotteryCount.isBiggerThan(number);

        assertThat(isBiggerThanNumber).isEqualTo(expected);
    }
}
