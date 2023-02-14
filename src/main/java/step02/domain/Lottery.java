package step02.domain;

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

}
