package step02;

import step02.domain.LotteryGroup;
import step02.domain.LotteryPrice;
import step02.domain.LotteryRunner;
import step02.domain.LotteryStandard;
import step02.domain.ProfitRate;
import step02.domain.WinningNumbers;
import step02.strategies.LottoNumberGenerator;
import step02.view.InputView;
import step02.view.ResultView;

import java.util.Map;

public class LotteryApplication {

    public static void main(String[] args) {
        LotteryPrice lotteryPrice = InputView.inputPurchasePrice();
        int numOfLottery = lotteryPrice.numOrLottery();
        ResultView.print(numOfLottery);

        LotteryGroup lotteryGroup = new LotteryGroup(numOfLottery, new LottoNumberGenerator());
        ResultView.print(lotteryGroup);

        WinningNumbers winningNumbers = InputView.inputLastWeekWinningNumber();
        LotteryRunner lotteryRunner = new LotteryRunner(winningNumbers, lotteryGroup);

        Map<LotteryStandard, Integer> result = lotteryRunner.findWinningResult();
        ProfitRate profitRate = lotteryRunner.calculateProfitRate(lotteryPrice, result);

        ResultView.print(result);
        ResultView.print(profitRate);
    }
}
