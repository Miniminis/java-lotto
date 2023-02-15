package step02.domain;

import java.util.ArrayList;
import java.util.List;
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

    public ProfitRate calculateProfitRate(int numOfLottery, Map<LotteryStandard, Integer> result) {
        List<LotteryStandard> resultKeys = new ArrayList<>(result.keySet());

        int totalCount = 0;
        for (LotteryStandard key : resultKeys) {
            totalCount += result.get(key);
        }

        return new ProfitRate(totalCount, numOfLottery);
    }
}
