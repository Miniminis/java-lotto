package xlffm3;

import xlffm3.domain.ManualLottery;
import xlffm3.domain.ManualLotteryCount;
import xlffm3.domain.PurchasePrice;
import xlffm3.view.InputView;

public class LottoApplication {

    public static void main(String[] args) {
        PurchasePrice purchasePrice = InputView.purchasePrice();
        ManualLotteryCount manualLotteryCount = InputView.manualLotteryCount(purchasePrice);
        ManualLottery manualLottery = InputView.manualLotteryNumbers(manualLotteryCount);



    }
}
