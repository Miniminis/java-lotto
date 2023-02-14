package step02.view;

import step02.domain.LotteryGroup;
import step02.domain.LotteryStandard;
import step02.domain.ProfitRate;
import step02.util.ScreenText;

import java.util.Map;

public class ResultView {

    public static void print(LotteryGroup lotteryGroup) {

    }

    public static void print(Map<LotteryStandard, Integer> result) {

    }

    public static void print(ProfitRate profitRate) {

    }

    public static void print(int numOfLottery) {
        System.out.println(String.format(ScreenText.CONFIRM_NUM_OF_LOTTERY, numOfLottery));
    }
}
