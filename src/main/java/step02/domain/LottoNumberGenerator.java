package step02.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    public static int pick() {
        List<Integer> lottoNumberCandidates = IntStream.range(1, 46).boxed().collect(Collectors.toList());
        Collections.shuffle(lottoNumberCandidates);

        return lottoNumberCandidates.get(0);
    }
}
