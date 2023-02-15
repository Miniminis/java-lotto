package step02.domain;

import java.util.Map;

public class LotteryRunner {

    private final WinningNumbers winningNumbers;
    private final LotteryGroup lotteryGroup;

    public LotteryRunner(WinningNumbers winningNumbers, LotteryGroup lotteryGroup) {
        this.winningNumbers = winningNumbers;
        this.lotteryGroup = lotteryGroup;
    }

    public Map<LotteryStandard, Integer> findWinningResult() {
        return lotteryGroup.matchResult(winningNumbers);
    }

    public ProfitRate calculateProfitRate(Map<LotteryStandard, Integer> result) {
        return null;
    }
}
