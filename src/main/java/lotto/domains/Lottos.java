package lotto.domains;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;

    public Lottos(int money) {
        this.lottos = readyLottos(numOfLotto(money));
    }

    public int numOfLotto() {
        return lottos.size();
    }

    public List<Lotto> lottos() {
        return lottos;
    }

    private int numOfLotto(int money) {
        if (money <= 1000) {
            throw new IllegalArgumentException("로또 최소 금액은 1000원 입니다.");
        }
        return money / LOTTO_PRICE;
    }

    private List<Lotto> readyLottos(int lottosCnt) {
        return IntStream
                .range(0, lottosCnt)
                .mapToObj(i -> new Lotto())
                .collect(Collectors.toList());
    }

}
