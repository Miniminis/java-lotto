package xlffm3.domain;

import java.util.List;

public class ManualLottery {

    private final ManualLotteryCount manualLotteryCount;
    private final List<String[]> manualNumbers;

    public ManualLottery(ManualLotteryCount manualLotteryCount, List<String[]> manualNumbers) {
        this.manualLotteryCount = manualLotteryCount;
        this.manualNumbers = manualNumbers;
    }


}
