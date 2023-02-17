package step02.strategies;

import org.assertj.core.util.Lists;

import java.util.List;

public class FixedNumberGenerator implements NumberGenerator {

    private final List<Integer> numbers;

    public FixedNumberGenerator() {
        this(Lists.newArrayList(10, 45, 7, 20, 5, 40));
    }

    public FixedNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> pickNumbers() {
        return numbers;
    }
}
