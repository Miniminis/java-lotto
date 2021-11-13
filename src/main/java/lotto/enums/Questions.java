package lotto.enums;

public enum Questions {

    QUESTION_PURCHASE_MONEY("구입금액을 입력해 주세요."),
    QUESTION_LAST_WEEK_WINNING_NUMBER("지난 주 당첨 번호를 입력해 주세요.");

    private final String question;

    Questions(String question) {
        this.question = question;
    }

    public String question() {
        return this.question;
    }

}
