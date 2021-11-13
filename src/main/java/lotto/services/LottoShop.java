package lotto.services;

import lotto.domains.Lotto;
import lotto.domains.LottoResults;
import lotto.domains.Lottos;
import lotto.domains.WinningNumber;

import java.util.List;

public class LottoShop {

    private final Lottos lottos;

    public LottoShop(int money) {
        this.lottos = new Lottos(money);
    }

    public int numOfLottos() {
        return lottos.numOfLotto();
    }

    public Lottos lottos() {
        return lottos;
    }

    public LottoResults winner(List<Integer> lastWeekWinningNumbers) {
        LottoResults lottoResults = new LottoResults();
        WinningNumber winningNumber = new WinningNumber(lastWeekWinningNumbers);

        for (Lotto lotto : lottos.lottos()) {
            lottoResults.addWinner(winningNumber.numOfWinningNumberMatchCnt(lotto));
        }

        return lottoResults;
    }

}
