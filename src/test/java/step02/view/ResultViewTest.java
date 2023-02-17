package step02.view;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step02.domain.LotteryGroup;
import step02.domain.LotteryPrice;
import step02.domain.ProfitRate;
import step02.strategies.FixedNumberGenerator;

@DisplayName("결과 출력 화면은")
class ResultViewTest {

    @ParameterizedTest
    @ValueSource(ints = {14, 3})
    void 입력된_로또의_개수를_출력한다(int numOfLottery) {
        ResultView.print(numOfLottery);
    }

    @Test
    void 입력된_로또그룹의_내용을_출력한다() {
        LotteryGroup lotteryGroup = new LotteryGroup(3, new FixedNumberGenerator(Lists.newArrayList(1, 2, 3, 4, 5, 6)));
        ResultView.print(lotteryGroup);
    }

    @ParameterizedTest
    @CsvSource(value = {"5000:15000", "15000:3000", "2000000000:1000", "5000:14000"}, delimiter = ':')
    void 로또_수익률을_출력한다(int totalWinningReward, String lotteryPrice) {
        ResultView.print(new ProfitRate(totalWinningReward, new LotteryPrice(lotteryPrice)));
    }
}
