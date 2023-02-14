package step02.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import step02.util.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 금액은")
class LotteryPriceTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 빈값이거나_null일경우_오류를_반환한다(String nullOfEmptyValue) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LotteryPrice(nullOfEmptyValue))
                .withMessage(ErrorMessage.NULL_OR_EMPTY);
    }

    @ParameterizedTest
    @ValueSource(strings = {"s", "!"})
    void 숫자타입이_아닐경우_오류를_반환한다(String notNumberTypeInput) {
        assertThatThrownBy(() -> new LotteryPrice(notNumberTypeInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.PRICE_TYPE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"900", "0", "-1000"})
    void 최소금액보다_작을경우_오류를_반환한다(String lowerThanOneThousand) {
        assertThatThrownBy(() -> new LotteryPrice(lowerThanOneThousand))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.PRICE_RANGE);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "14000:14"}, delimiter = ':')
    void 가격범위에_맞춰_개수를_반환한다(String inputPrice, int expected) {
        LotteryPrice lotteryPrice = new LotteryPrice(inputPrice);
        assertThat(lotteryPrice.numOrLottery()).isEqualTo(expected);
    }
}
