package step02.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import step02.strategies.FixedNumberGenerator;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static step02.providers.TestProviders.WINNING_NUMBER;

@DisplayName("로또 추첨을 시작하면")
class LotteryRunnerTest {

    @ParameterizedTest
    @MethodSource("step02.providers.TestProviders#getMatchCountAndLotteryNumbers")
    void 당첨번호와_로또번호사이에_일치하는_개수가_기록된다(int matchCount, List<Integer> lottoNumbers) {
        WinningNumbers winningNumbers = new WinningNumbers(WINNING_NUMBER);
        LotteryGroup lotteryGroup = new LotteryGroup(1, new FixedNumberGenerator(lottoNumbers));

        LotteryRunner lotteryRunner = new LotteryRunner(winningNumbers, lotteryGroup);
        Map<LotteryStandard, Integer> winningResult = lotteryRunner.findWinningResult();

        assertThat(winningResult.get(LotteryStandard.valueByCount(matchCount))).isEqualTo(1);
    }

}
