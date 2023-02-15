package step02.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step02.strategies.FixedNumberGenerator;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("로또 추첨을 시작하면")
class LotteryRunnerTest {

    private static final String STR_WINNING_NUMBERS = "10, 45, 23, 17, 33, 5";

    @ParameterizedTest
    @MethodSource("getMatchCountAndLotteryNumbers")
    void 당첨번호와_로또번호사이에_일치하는_개수가_기록된다(int matchCount, List<Integer> lottoNumbers) {
        WinningNumbers winningNumbers = new WinningNumbers(STR_WINNING_NUMBERS);
        LotteryGroup lotteryGroup = new LotteryGroup(1, new FixedNumberGenerator(lottoNumbers));

        LotteryRunner lotteryRunner = new LotteryRunner(winningNumbers, lotteryGroup);
        Map<LotteryStandard, Integer> winningResult = lotteryRunner.findWinningResult();

        assertThat(winningResult.get(LotteryStandard.valueByCount(matchCount))).isEqualTo(1);
    }

    static Stream<Arguments> getMatchCountAndLotteryNumbers() {
        return Stream.of(
                arguments(3, Lists.newArrayList(10, 45, 23, 20, 35, 6)),
                arguments(4, Lists.newArrayList(10, 45, 23, 17, 34, 4)),
                arguments(5, Lists.newArrayList(10, 45, 23, 17, 33, 2)),
                arguments(6, Lists.newArrayList(10, 45, 23, 17, 33, 5))
        );
    }

}
