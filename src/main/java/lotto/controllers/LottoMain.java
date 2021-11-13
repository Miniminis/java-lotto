package lotto.controllers;

import lotto.domains.LottoResults;
import lotto.services.LottoShop;
import lotto.views.InputView;
import lotto.views.ResultView;

public class LottoMain {

    public static void main(String[] args) {
        try {
            int money = InputView.money();

            LottoShop lottoShop = new LottoShop(money);

            ResultView.printLottoCount(lottoShop.numOfLottos());
            ResultView.printLottos(lottoShop.lottos());

            LottoResults lottoResults = lottoShop.winner(InputView.lastWeekWinningNumbers());

            ResultView.printLottoResult(lottoResults);
            ResultView.printProfitRate(lottoResults.profitRate(money));

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

}
