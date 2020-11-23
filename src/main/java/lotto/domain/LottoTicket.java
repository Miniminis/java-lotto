package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private static final int MIN_COUNT_TO_PRIZE = 3;

    private List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers){
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getSortedLottoNumbers(){
        Collections.sort(this.lottoNumbers);
        return this.lottoNumbers;
    }

    public PrizeUnit countWinningNumbers(List<Integer> lastWinningNumbers, int bonusNumber) {
        List<Integer> winningsNumber = lottoNumbers
                .stream().filter(element -> lastWinningNumbers.contains(element)).collect(Collectors.toList());

        boolean isMatchBonusNumber = lottoNumbers.contains(bonusNumber);

        int winningNumberSize = winningsNumber.size();

        if(winningNumberSize == PrizeUnit.SECOND_GRADE.prizeUnitCount && isMatchBonusNumber){
            return PrizeUnit.SECOND_GRADE;
        }

        if(winningNumberSize < MIN_COUNT_TO_PRIZE){
            winningNumberSize = 0;
        }

        return PrizeUnit.findPrizeFieldByUnitCount(winningNumberSize, false);
    }

}
