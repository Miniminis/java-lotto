package step02.domain;

import step02.util.ErrorMessage;
import step02.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {

    private final List<LottoNumber> numbers;

    public WinningNumbers(String stringNumbers) {
        validateNotNullAndNotEmpty(stringNumbers);
        numbers = toLottoNumberList(stringNumbers);
    }

    private List<LottoNumber> toLottoNumberList(String stringNumbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        String[] stringArray = stringNumbers.replaceAll(" ", "").split(",");
        for (String str : stringArray) {
            lottoNumbers.add(new LottoNumber(toInt(str)));
        }
        return lottoNumbers;
    }

    private int toInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_WRONG_RANGE);
        }
    }

    private void validateNotNullAndNotEmpty(String stringNumbers) {
        if (Validator.isNullOrEmpty(stringNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.NULL_OR_EMPTY);
        }
    }

    public List<LottoNumber> values() {
        return numbers;
    }
}
