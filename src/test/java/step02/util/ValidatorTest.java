package step02.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("유효성 검사 테스트")
class ValidatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 입력값이_nullorempty_이면_true_를_반환한다(String input) {
        boolean result = Validator.isNullOrEmpty(input);
        assertThat(result).isTrue();
    }

}
