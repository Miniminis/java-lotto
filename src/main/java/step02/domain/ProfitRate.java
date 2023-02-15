package step02.domain;

public class ProfitRate {

    private final double rate;

    public ProfitRate(int totalCount, int numOfLottery) {
        this.rate = (double) totalCount / (double) numOfLottery;
    }

    @Override
    public String toString() {
        return String.format("%.2f", rate);
    }

}
