package step02.providers;

import org.assertj.core.util.Lists;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TestProviders {

    public static final String WINNING_NUMBER = "10, 45, 7, 20, 6, 39";

    static Stream<Arguments> getMatchCountAndLotteryNumbers() {
        return Stream.of(
                arguments(3, Lists.newArrayList(10, 45, 7, 19, 5, 38)),
                arguments(4, Lists.newArrayList(10, 45, 7, 20, 5, 40)),
                arguments(4, Lists.newArrayList(10, 45, 7, 20, 5, 23)),
                arguments(5, Lists.newArrayList(10, 45, 7, 20, 6, 37)),
                arguments(6, Lists.newArrayList(10, 45, 7, 20, 6, 39))
        );
    }

}
