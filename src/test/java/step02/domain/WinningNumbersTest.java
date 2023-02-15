package step02.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import step02.util.ErrorMessage;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("당첨번호는")
class WinningNumbersTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 빈값이면_오류를_반환한다(String input) {
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NULL_OR_EMPTY);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, !, @", "a, b, c, d, 2, 3"})
    void 숫자형식이_아니면_오류를_반환한다(String input) {
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_WRONG_RANGE);
    }

    @ParameterizedTest
    @MethodSource
    void string타입으로_입력되어_길이가_6인_int리스트로_쪼개진다(String stringArray, List<LottoNumber> winningNumberList) {
        WinningNumbers winningNumbers = new WinningNumbers(stringArray);

        for (int i = 0; i < winningNumberList.size(); i++) {
            assertThat(winningNumberList.get(i)).isEqualTo(winningNumbers.values().get(i));
        }
    }

    public static Stream<Arguments> string타입으로_입력되어_길이가_6인_int리스트로_쪼개진다() {
        return Stream.of(
                arguments("1, 2, 3, 4, 5, 6", Lists.newArrayList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))),
                arguments("10, 45, 7, 23, 40, 21", Lists.newArrayList(new LottoNumber(10), new LottoNumber(45), new LottoNumber(7), new LottoNumber(23), new LottoNumber(40), new LottoNumber(21)))
        );
    }

}
