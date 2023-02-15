package step02.domain;

import step02.strategies.NumberGenerator;
import step02.util.CommonText;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottery {

    private static final int FIRST_INDEX = 0;
    private static final int LAST_INDEX = 6;

    private final List<LottoNumber> numbers;

    public Lottery(NumberGenerator numberGenerator) {
        numbers = IntStream.range(FIRST_INDEX, LAST_INDEX)
                .mapToObj(n -> new LottoNumber(numberGenerator.pick(n)))
                .collect(Collectors.toList());
    }

    public int size() {
        return numbers.size();
    }

    private String suffix(int index, int lastIndex) {
        if (index != lastIndex) {
            return CommonText.COMMA + CommonText.BLANK;
        }
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottery lottery = (Lottery) o;
        return Objects.equals(numbers, lottery.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        int lastIndex = size() - 1;

        StringBuilder sb = new StringBuilder();
        sb.append(CommonText.BRACKET_SQR_OPEN);

        for (int i = 0; i <= lastIndex; i++) {
            sb.append(numbers.get(i));
            sb.append(suffix(i, lastIndex));
        }

        sb.append(CommonText.BRACKET_SQR_CLOSE);
        return sb.toString();
    }

    public int matchCount(WinningNumbers winningNumbers) {
        int matchCount = 0;

        for (LottoNumber lottoNumber : winningNumbers.values()) {
            matchCount += contains(lottoNumber);
        }
        return matchCount;
    }

    private int contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber) ? 1 : 0;
    }
}
