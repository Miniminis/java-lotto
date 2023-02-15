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

@DisplayName("로또 1개는")
class LotteryTest {

    private final static int LOTTERY_NUMBER_LIMIT = 6;
    public static final String WINNING_NUMBER = "10, 45, 7, 20, 6, 39";

    @ParameterizedTest
    @MethodSource("getMatchCountAndLotteryNumbers")
    void 당첨번호와_일치하는개수를_계산한다(int expectedCount, List<Integer> numbers) {
        WinningNumbers winningNumbers = new WinningNumbers(WINNING_NUMBER);
        Lottery lottery = new Lottery(new FixedNumberGenerator(numbers));

        int matchCount = lottery.matchCount(winningNumbers);

        assertThat(matchCount).isEqualTo(expectedCount);
    }

    @Test
    void 정확하게_6개의_로또번호로_구성된다() {
        Lottery lottery = new Lottery(new FixedNumberGenerator());
        assertThat(lottery.size()).isEqualTo(LOTTERY_NUMBER_LIMIT);
    }

    @ParameterizedTest
    @MethodSource("getLotteryNumbers")
    void toString을_호출하면_로또의_6개숫자가_출력된다(List<Integer> numbers) {
        Lottery lottery = new Lottery(new FixedNumberGenerator(numbers));
        assertThat(lottery).isEqualTo(new Lottery(new FixedNumberGenerator(numbers)));
    }

    static Stream<Arguments> getLotteryNumbers() {
        return Stream.of(
                arguments(Lists.newArrayList(10, 45, 7, 20, 6, 39)),    //6
                arguments(Lists.newArrayList(10, 45, 7, 20, 6, 40)),    //5
                arguments(Lists.newArrayList(10, 45, 7, 20, 17, 41)),   //4
                arguments(Lists.newArrayList(10, 45, 8, 20, 17, 39)),   //4
                arguments(Lists.newArrayList(10, 45, 8, 19, 17, 41)),   //3
                arguments(Lists.newArrayList(10, 44, 3, 19, 17, 41))    //1
        );
    }

    static Stream<Arguments> getMatchCountAndLotteryNumbers() {
        return Stream.of(
                arguments(6, Lists.newArrayList(10, 45, 7, 20, 6, 39)),    //6
                arguments(5, Lists.newArrayList(10, 45, 7, 20, 6, 40)),    //5
                arguments(4, Lists.newArrayList(10, 45, 7, 20, 17, 41)),   //4
                arguments(4, Lists.newArrayList(10, 45, 8, 20, 17, 39)),   //4
                arguments(3, Lists.newArrayList(10, 45, 7, 19, 17, 41)),   //3
                arguments(1, Lists.newArrayList(10, 44, 3, 19, 17, 41))    //1
        );
    }

}
