package xlffm3.view;

import xlffm3.domain.ManualLottery;
import xlffm3.utils.CommonValue;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static long purchasePrice() {
        System.out.println(ViewMessage.QUESTION_PURCHASE_PRICE);
        return Long.parseLong(SCANNER.nextLine());
    }

    public static int manualLotteryCount() {
        System.out.println(ViewMessage.QUESTION_MANUAL_LOTTERY_COUNT);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static ManualLottery manualLotteryNumbers(int manualLotteryCount) {
        if (manualLotteryCount > CommonValue.ZERO) {
            System.out.println(ViewMessage.QUESTION_MANUAL_LOTTERY_NUMBERS);
        }

        List<String[]> manualNumbers = Stream
                .generate(() -> SCANNER.nextLine().trim().split(CommonValue.COMMA))
                .limit(manualLotteryCount)
                .collect(Collectors.toList());

        return new ManualLottery(manualLotteryCount, manualNumbers);
    }

}
