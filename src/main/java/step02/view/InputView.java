package step02.view;

import step02.domain.LotteryPrice;
import step02.domain.WinningNumbers;
import step02.util.ScreenText;

import java.util.Scanner;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static LotteryPrice inputPurchasePrice() {
        System.out.println(ScreenText.QUESTION_PURCHASE_PRICE);
        return new LotteryPrice(sc.nextLine());
    }

    public static WinningNumbers inputLastWeekWinningNumber() {
        System.out.println(ScreenText.QUESTION_LAST_WEEK_WINNING_NUMBER);
        return new WinningNumbers(sc.nextLine());
    }
}
