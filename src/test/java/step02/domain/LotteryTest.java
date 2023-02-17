package step02.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step02.strategies.FixedNumberGenerator;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static step02.providers.TestProviders.WINNING_NUMBER;

@DisplayName("로또 1개는")
class LotteryTest {

    private static final int LOTTERY_NUMBER_LIMIT = 6;

    @ParameterizedTest
    @MethodSource("getLotteryNumbers")
    void 당첨번호와_일치하는개수를_계산한다(int expectedCount, List<Integer> numbers) {
        WinningNumbers winningNumbers = new WinningNumbers(WINNING_NUMBER);
        Lottery lottery = new Lottery(new FixedNumberGenerator(numbers).pickNumbers());

        int matchCount = lottery.matchCount(winningNumbers);

        assertThat(matchCount).isEqualTo(expectedCount);
    }

    @ParameterizedTest
    @MethodSource("getLotteryNumbers")
    void toString을_호출하면_로또의_6개숫자가_출력된다(int matchCount, List<Integer> numbers) {
        Lottery lottery = new Lottery(new FixedNumberGenerator(numbers).pickNumbers());
        assertThat(lottery).isEqualTo(new Lottery(new FixedNumberGenerator(numbers).pickNumbers()));
    }

    static Stream<Arguments> getLotteryNumbers() {
        return Stream.of(
                arguments(6, Lists.newArrayList(10, 45, 7, 20, 6, 39)),
                arguments(5, Lists.newArrayList(10, 45, 7, 20, 6, 40)),
                arguments(4, Lists.newArrayList(10, 45, 7, 20, 17, 41)),
                arguments(4, Lists.newArrayList(10, 45, 8, 20, 17, 39)),
                arguments(3, Lists.newArrayList(10, 45, 7, 19, 17, 41)),
                arguments(1, Lists.newArrayList(10, 44, 3, 19, 17, 41))
        );
    }

    @Test
    void 정확하게_6개의_로또번호로_구성된다() {
        Lottery lottery = new Lottery(new FixedNumberGenerator().pickNumbers());
        assertThat(lottery.size()).isEqualTo(LOTTERY_NUMBER_LIMIT);
    }
}
