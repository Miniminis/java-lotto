package step02.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("데이터 파싱 테스트")
class ParserTest {

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:1"}, delimiter = ':')
    void 전달된_문자열을_숫자로_변환한다(String input, int expected) {
        int parsedNumber = Parser.parseStringToInt(input);
        assertThat(parsedNumber).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"s", "a"})
    void 전달된_문자열이_숫자타입이_아니면_오류를_반환한다(String input) {
        assertThatThrownBy(() -> Parser.parseStringToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.PRICE_TYPE);
    }

}
