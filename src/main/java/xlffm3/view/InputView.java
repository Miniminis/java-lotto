package xlffm3.view;

import xlffm3.domain.ManualLottery;
import xlffm3.domain.ManualLotteryCount;
import xlffm3.domain.PurchasePrice;
import xlffm3.utils.CommonValue;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static PurchasePrice purchasePrice() {
        System.out.println(ViewMessage.QUESTION_PURCHASE_PRICE);
        return new PurchasePrice(Long.parseLong(SCANNER.nextLine()));
    }

    public static ManualLotteryCount manualLotteryCount(PurchasePrice purchasePrice) {
        System.out.println(ViewMessage.QUESTION_MANUAL_LOTTERY_COUNT);
        return new ManualLotteryCount(Integer.parseInt(SCANNER.nextLine()), purchasePrice);
    }

    public static ManualLottery manualLotteryNumbers(ManualLotteryCount manualLotteryCount) {
        if (manualLotteryCount.isBiggerThan(CommonValue.ZERO)) {
            System.out.println(ViewMessage.QUESTION_MANUAL_LOTTERY_NUMBERS);
        }

        List<String[]> manualNumbers = Stream
                .generate(() -> SCANNER.nextLine().trim().split(CommonValue.COMMA))
                .limit(manualLotteryCount.getCount())
                .collect(Collectors.toList());

        return new ManualLottery(manualLotteryCount, manualNumbers);
    }

}
