package step02.strategies;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 번호 생성기는")
class LottoNumberGeneratorTest {

    @Test
    void _1이상_45이하의_숫자를_랜덤으로_생성하여_반환한다() {
        List<Integer> picked = new LottoNumberGenerator().pickNumbers();

        for (int number : picked) {
            assertThat(number >= 1 && number <= 45).isTrue();
        }
    }
}
