package step02.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step02.util.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("각 로또의 로또 번호는")
class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 45})
    void 정확하게_1이상_45_이하의_값으로만_이루어진다(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 만약_1미만_혹은_45초과의_값이_주어지면_오류를_반환한다(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_WRONG_RANGE);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 45})
    void toString을_호출하면_자기자신의_값을_반환한다(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);
        assertThat(lottoNumber.toString()).isEqualTo(String.valueOf(number));
    }
}
