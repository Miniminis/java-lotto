package lotto.domains;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    void 구입금액만큼_로또개수_생성하기() {
        Lottos lottos = new Lottos(14000);

        assertThat(lottos.numOfLotto()).isEqualTo(14);
    }

    @Test
    void 구입금액_부족할떄() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Lottos(0));
    }
}