package step02.strategies;

import java.util.List;

@FunctionalInterface
public interface NumberGenerator {
    List<Integer> pickNumbers();
}
