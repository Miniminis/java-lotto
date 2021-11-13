package lotto.views;

import lotto.enums.Questions;
import utils.DataParser;
import utils.StringUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    public static final Scanner scanner = new Scanner(System.in);

    public static int money() {
        askQuestion(Questions.QUESTION_PURCHASE_MONEY.question());
        return DataParser.parseToInt(input());
    }

    public static List<Integer> lastWeekWinningNumbers() {
        askQuestion(Questions.QUESTION_LAST_WEEK_WINNING_NUMBER.question());
        return Arrays.stream(StringUtil.spliter(input()))
                .map(DataParser::parseToInt)
                .collect(Collectors.toList());
    }

    private static void askQuestion(String question) {
        System.out.println(question);
    }

    private static String input() {
        return scanner.nextLine();
    }

}
