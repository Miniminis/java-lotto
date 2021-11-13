package lotto.domains;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumberTest {

    @Test
    void 당첨번호_생성() {
        List<Integer> winningNumbers = Lists.newArrayList(1, 5, 2, 10, 32, 43);

        assertThat(new WinningNumber(winningNumbers)).isEqualTo(new WinningNumber(winningNumbers));
    }

    @Test
    void 일치하는_번호_개수_찾기() {
        List<Integer> winningNumbers = Lists.newArrayList(1, 2, 3, 4, 32, 10);

        WinningNumber winningNumber = new WinningNumber(winningNumbers);
        Lotto lotto = new Lotto(Lists.newArrayList(1, 2, 3, 4, 5, 10));

        int result = winningNumber.numOfWinningNumberMatchCnt(lotto);

        assertThat(result).isEqualTo(5);
    }
}