package step01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("문자열 덧셈 계산기 테스트")
public class StringPlusCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmpty(String input) {
        assertThat(StringPlusCalculator.splitAndSum(input)).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "9"})
    void oneNumber(String number) {
        assertThat(StringPlusCalculator.splitAndSum(number)).isEqualTo(Integer.valueOf(number));
    }

    @ParameterizedTest
    @CsvSource(value= {"1,2:3=6", "4,3=7", "1:2,7=10", "3:1,0=4"}, delimiter = '=')
    void twoNumbersWithCommaOrColon(String input, int expected) {
        assertThat(StringPlusCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @Test
    void twoNumbersWithCustomDelimiter() {
        assertThat(StringPlusCalculator.splitAndSum("//#\n5#2#3")).isEqualTo(10);
        assertThat(StringPlusCalculator.splitAndSum("//;\n1;3;5")).isEqualTo(9);
    }

    @ParameterizedTest
    @ValueSource(strings= {"-1,2", "s,3"})
    void exceptionIfNotNumberOrMinusNumber(String input) {
        assertThatThrownBy(() -> StringPlusCalculator.splitAndSum(input))
                .isInstanceOf(RuntimeException.class);
    }
}
