package step02.strategies;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator implements NumberGenerator {

    private static final int START_IDX = 1;
    private static final int END_IDX = 46;

    private static final int SUB_START_IDX = 0;
    private static final int SUB_END_IDX = 6;


    @Override
    public List<Integer> pickNumbers() {
        List<Integer> lottoNumberCandidates = IntStream.range(START_IDX, END_IDX).boxed().collect(Collectors.toList());
        Collections.shuffle(lottoNumberCandidates);

        return lottoNumberCandidates.subList(SUB_START_IDX, SUB_END_IDX);
    }
}
