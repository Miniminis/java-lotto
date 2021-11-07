package lotto.views;

import java.util.Scanner;

public class InputView {

    private static final String QUESTION_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    private static final String QUESTION_LAST_WEEK_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

    public static final Scanner scanner = new Scanner(System.in);

    public static String takeMoney() {
        askQuestion(QUESTION_PURCHASE_MONEY);
        return getInput();
    }

    public static String getLastWeekWinnerNumbers() {
        askQuestion(QUESTION_LAST_WEEK_WINNING_NUMBER);
        return getInput();
    }

    private static void askQuestion(String question) {
        System.out.println(question);
    }

    private static String getInput() {
        return scanner.nextLine();
    }

}
