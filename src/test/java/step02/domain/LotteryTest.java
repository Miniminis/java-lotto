package step02.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 1개는")
class LotteryTest {

    private final static int LOTTERY_NUMBER_LIMIT = 6;

    @Test
    void 정확하게_6개의_로또번호로_구성된다() {
        Lottery lottery = new Lottery();
        assertThat(lottery.size()).isEqualTo(LOTTERY_NUMBER_LIMIT);
    }

    @Test
    void toString을_호출하면_로또의_6개숫자가_출력된다() {
        Lottery lottery = new Lottery();
        System.out.println(lottery);
    }
}
