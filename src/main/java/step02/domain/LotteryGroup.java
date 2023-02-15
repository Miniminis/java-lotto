package step02.domain;

import step02.util.ErrorMessage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryGroup {

    private final List<Lottery> lotteries;

    public LotteryGroup(int numOfLottery) {
        validateNumOfLottery(numOfLottery);

        lotteries = IntStream.range(0, numOfLottery)
                .mapToObj(n -> new Lottery())
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Lottery lottery : lotteries) {
            sb.append(lottery).append("\n");
        }

        return sb.toString();
    }
}
