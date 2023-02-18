package xlffm3;

import xlffm3.domain.PurchasePrice;
import xlffm3.view.InputView;

public class LottoApplication {

    public static void main(String[] args) {
        PurchasePrice purchasePrice = PurchasePrice.of(InputView.purchasePrice());
    }
}
