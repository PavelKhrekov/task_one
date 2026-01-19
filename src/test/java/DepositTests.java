import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test_task.classes.Deposit;
import test_task.enums.Currency;

import java.math.BigDecimal;

public class DepositTests {

    private Deposit deposit;

    @BeforeEach
    public void before() {
        deposit = new Deposit(Currency.RUB, "500", "deposit");
    }

    @Test
    public void test1() {
        Assertions.assertTrue(deposit.isActive());
        deposit.increaseBalance("100");
        Assertions.assertEquals(new BigDecimal("600"), deposit.getBalance());
    }

    @Test
    public void test2() {
        deposit.closeDeposit();
        Assertions.assertFalse(deposit.isActive());
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            deposit.increaseBalance("100");
        });
    }

    @Test
    public void test3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            deposit.increaseBalance(null);
        });
    }

    @Test
    public void test4() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            deposit.increaseBalance("qwe");
        });
    }

    @Test
    public void test5() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            deposit.increaseBalance("-100");
        });
    }

}
