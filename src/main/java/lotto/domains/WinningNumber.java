package lotto.domains;

import utils.DataParser;
import utils.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WinningNumber {

    private final List<Integer> winningNumbers;

    public WinningNumber(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public WinningNumber(String numberArrString) {
        winningNumbers = new ArrayList<>();

        String[] numbers = StringUtil.spliter(numberArrString);
        
        for (String number : numbers) {
            winningNumbers.add(DataParser.parseToInt(number));
        }
    }

    public int numOfWinningNumberMatchCnt(Lotto lotto) {
        if (winningNumbers.size() != lotto.size()) {
            throw new IllegalArgumentException("당첨 번호와 로또 숫자의 길이가 같지 않습니다.");
        }

        int matchCnt = 0;
        for (int i = 0; i < lotto.size(); i++) {
            if (winningNumbers.contains(lotto.number(i))) {
                matchCnt++;
            }
        }

        return matchCnt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumber that = (WinningNumber) o;
        return Objects.equals(winningNumbers, that.winningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers);
    }
}
