package step01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("유효성 검사 테스트")
class ValidatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void isNullOrEmptyTest(String str) {
        assertThat(Validator.isNullOrEmpty(str)).isTrue();
    }
}
