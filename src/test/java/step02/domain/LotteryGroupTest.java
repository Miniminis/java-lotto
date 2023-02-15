package step02.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step02.util.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 그룹은")
class LotteryGroupTest {

    @ParameterizedTest
    @ValueSource(ints = {14, 2})
    void 입력된_개수만큼_로또를_생성한다(int numOfLottery) {
        LotteryGroup lotteryGroup = new LotteryGroup(numOfLottery);
        assertThat(lotteryGroup.size()).isEqualTo(numOfLottery);
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, 0})
    void 입력된_개수가_음수이거나_ZERO일경우_오류를_반환한다(int numOfLottery) {
        assertThatThrownBy(() -> new LotteryGroup(numOfLottery))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ZERO_NUM_OF_LOTTERY);
    }

    @Test
    void toString을_호출하면_로또그룹이_출력된다() {
        LotteryGroup lotteryGroup = new LotteryGroup(3);
        System.out.println(lotteryGroup);
    }
}
