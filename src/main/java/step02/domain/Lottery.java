package step02.domain;

import step02.util.CommonText;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottery {

    private static final int FIRST_INDEX = 0;
    private static final int LAST_INDEX = 6;

    private final List<LottoNumber> numbers;

    public Lottery() {
        numbers = IntStream.range(FIRST_INDEX, LAST_INDEX)
                .mapToObj(n -> new LottoNumber(LottoNumberGenerator.pick()))
                .collect(Collectors.toList());
    }

    public int size() {
        return numbers.size();
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

    private String suffix(int index, int lastIndex) {
        if (index != lastIndex) {
            return CommonText.COMMA + CommonText.BLANK;
        }
        return "";
    }
}
