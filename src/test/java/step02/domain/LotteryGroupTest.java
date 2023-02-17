package step02.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step02.providers.TestProviders;
import step02.strategies.FixedNumberGenerator;
import step02.util.ErrorMessage;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 그룹은")
class LotteryGroupTest {

    @Test
    void 당첨번호와_일치하는_로또에_대해_통계를_낸다() {
        LotteryGroup lotteryGroup = new LotteryGroup(1, new FixedNumberGenerator(Lists.newArrayList(10, 45, 7, 20, 5, 40)));
        Map<LotteryStandard, Integer> matchResult = lotteryGroup.matchResult(new WinningNumbers(TestProviders.WINNING_NUMBER));

        assertThat(matchResult.get(LotteryStandard.THREE)).isEqualTo(0);
        assertThat(matchResult.get(LotteryStandard.FOUR)).isEqualTo(1);
        assertThat(matchResult.get(LotteryStandard.FIVE)).isEqualTo(0);
        assertThat(matchResult.get(LotteryStandard.SIX)).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {14, 2})
    void 입력된_개수만큼_로또를_생성한다(int numOfLottery) {
        LotteryGroup lotteryGroup = new LotteryGroup(numOfLottery, new FixedNumberGenerator());
        assertThat(lotteryGroup.size()).isEqualTo(numOfLottery);
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, 0})
    void 입력된_개수가_음수이거나_ZERO일경우_오류를_반환한다(int numOfLottery) {
        assertThatThrownBy(() -> new LotteryGroup(numOfLottery, new FixedNumberGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ZERO_NUM_OF_LOTTERY);
    }

    @Test
    void toString을_호출하면_로또그룹이_출력된다() {
        LotteryGroup lotteryGroup = new LotteryGroup(3, new FixedNumberGenerator());
        System.out.println(lotteryGroup);
    }

}
