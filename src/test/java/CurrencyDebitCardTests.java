import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test_task.classes.CurrencyDebitCard;
import test_task.enums.Currency;

import java.math.BigDecimal;

public class CurrencyDebitCardTests {

    @Test
    public void test1() {
        CurrencyDebitCard currencyDebitCard = new CurrencyDebitCard(Currency.USD, "500", "currencyDebitCard");
        Assertions.assertEquals(new BigDecimal("500"), currencyDebitCard.getBalance());
    }
}
