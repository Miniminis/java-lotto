package step02;

import step02.domain.LotteryGroup;
import step02.domain.LotteryRunner;
import step02.domain.LotteryStandard;
import step02.domain.ProfitRate;
import step02.view.InputView;
import step02.view.ResultView;

import java.util.Map;

public class LotteryApplication {

    public static void main(String[] args) {
        LotteryGroup lotteryGroup = new LotteryGroup(InputView.inputPurchasePrice());
        ResultView.print(lotteryGroup);

        LotteryRunner lotteryRunner = new LotteryRunner(InputView.inputLastWeekWinningNumber());
        Map<LotteryStandard, Integer> result = lotteryRunner.findWinningResult();
        ProfitRate profitRate = lotteryRunner.calculateProfitRate(result);

        ResultView.print(result);
        ResultView.print(profitRate);
    }
}
