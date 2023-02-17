package step02.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("로또의 수익률은")
class ProfitRateTest {

    @ParameterizedTest
    @CsvSource(value = {"5000:1000", "15000:3000", "2000000000:1000"}, delimiter = ':')
    void 전체당첨금액에서_구입금액을_나누어_구한다(int totalWinningReward, String lotteryPrice) {
        System.out.println(new ProfitRate(totalWinningReward, new LotteryPrice(lotteryPrice)));
    }
}
