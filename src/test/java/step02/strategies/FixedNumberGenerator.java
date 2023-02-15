package step02.strategies;

import org.assertj.core.util.Lists;

import java.util.List;

public class FixedNumberGenerator implements NumberGenerator {

    private final List<Integer> numbers;

    public FixedNumberGenerator() {
        this(Lists.newArrayList(1, 2, 3, 4, 5, 6));
    }

    public FixedNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public int pick(int index) {
        return numbers.get(index);
    }
}
