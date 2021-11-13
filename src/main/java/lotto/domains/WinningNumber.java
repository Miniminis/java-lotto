package lotto.domains;

import utils.DataParser;
import utils.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class WinningNumber {

    private final List<Integer> winningNumbers;

    public WinningNumber(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int numOfWinningNumberMatchCnt(Lotto lotto) {
        if (winningNumbers.size() != lotto.size()) {
            throw new IllegalArgumentException("당첨 번호와 로또 숫자의 길이가 같지 않습니다.");
        }

        return (int) IntStream.range(0, lotto.size())
                .filter(i -> winningNumbers.contains(lotto.number(i)))
                .count();
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
