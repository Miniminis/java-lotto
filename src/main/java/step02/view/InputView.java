package step02.view;

import step02.domain.LotteryPrice;
import step02.domain.WinningNumbers;
import step02.util.ScreenText;

import java.util.Scanner;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static int inputPurchasePrice() {
        System.out.println(ScreenText.QUESTION_PURCHASE_PRICE);
        LotteryPrice lotteryPrice = new LotteryPrice(sc.nextLine());

        return lotteryPrice.numOrLottery();
    }

    public static WinningNumbers inputLastWeekWinningNumber() {
        return new WinningNumbers();
    }
}
