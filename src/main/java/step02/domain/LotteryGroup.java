package step02.domain;

import step02.strategies.NumberGenerator;
import step02.util.ErrorMessage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryGroup {

    private final List<Lottery> lotteries;

    public LotteryGroup(int numOfLottery, NumberGenerator numberGenerator) {
        validateNumOfLottery(numOfLottery);

        lotteries = IntStream.range(0, numOfLottery)
                .mapToObj(n -> new Lottery(numberGenerator.pickNumbers()))
                .collect(Collectors.toList());
    }

    private void validateNumOfLottery(int numOfLottery) {
        if (numOfLottery <= 0) {
            throw new IllegalArgumentException(ErrorMessage.ZERO_NUM_OF_LOTTERY);
        }
    }

    public int size() {
        return lotteries.size();
    }

    public Map<LotteryStandard, Integer> matchResult(WinningNumbers winningNumbers) {
        Map<LotteryStandard, Integer> matchResult = new HashMap<>();
        Map<Integer, Integer> countingResult = new HashMap<>();

        for (int i = 0; i < lotteries.size(); i++) {
            int matchCount = lotteries.get(i).matchCount(winningNumbers);
            countingResult.put(matchCount, countingResult.getOrDefault(matchCount, 0) + 1);
        }

        LotteryStandard[] standards = LotteryStandard.values();
        for (LotteryStandard standard : standards) {
            matchResult.put(standard, countingResult.getOrDefault(standard.getCount(), 0));
        }

        return matchResult;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Lottery lottery : lotteries) {
            sb.append(lottery).append("\n");
        }

        return sb.toString();
    }
}
