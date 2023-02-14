package step02.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("결과 출력 화면은")
class ResultViewTest {

    @ParameterizedTest
    @ValueSource(ints = {14, 3})
    void 입력된_로또의_개수를_출력한다(int numOfLottery) {
        ResultView.print(numOfLottery);
    }
}
