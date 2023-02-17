package step02.domain;

public class ProfitRate {

    private final double rate;

    public ProfitRate(int totalWinningReward, LotteryPrice lotteryPrice) {
        this.rate = (double) totalWinningReward / (double) lotteryPrice.value();
    }

    @Override
    public String toString() {
        return String.format("%.2f", rate);
    }

}
