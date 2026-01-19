import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test_task.classes.CreditCard;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CreditCardTests {

    private CreditCard creditCard;

    @BeforeEach
    public void before() {
        creditCard = new CreditCard("500", "creditCard", "5.5", "1000");
    }

    @Test
    public void test1() {
        BigDecimal debt = creditCard.getDebt(30);
        Assertions.assertEquals(BigDecimal.valueOf(2.261), debt.setScale(3, RoundingMode.UP));
    }

    @Test
    public void test2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            creditCard.getDebt(-30);
        });
    }

    @Test
    public void test3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            creditCard.getDebt(0);
        });
    }

}
