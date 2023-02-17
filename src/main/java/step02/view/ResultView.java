package step02.view;

import step02.domain.LotteryGroup;
import step02.domain.LotteryStandard;
import step02.domain.ProfitRate;
import step02.util.ScreenText;

import java.util.Map;
import java.util.TreeMap;

public class ResultView {

    public static void print(LotteryGroup lotteryGroup) {
        System.out.println(lotteryGroup);
    }

    public static void print(Map<LotteryStandard, Integer> result) {
        System.out.println(ScreenText.RESULT_TITLE);
        System.out.println(ScreenText.TITLE_LINE);

        new TreeMap<>(result).forEach((lotteryStandard, integer) -> {
            System.out.println(
                    String.format(ScreenText.MATCH_RESULT, lotteryStandard.getCount(), lotteryStandard.getAmount(), integer)
            );
        });
    }

    public static void print(ProfitRate profitRate) {
        System.out.println(String.format(ScreenText.RESULT_WINNING_RATE, profitRate));
    }

    public static void print(int numOfLottery) {
        System.out.println(String.format(ScreenText.CONFIRM_NUM_OF_LOTTERY, numOfLottery));
    }
}
