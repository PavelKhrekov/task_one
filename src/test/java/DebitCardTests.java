import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test_task.classes.DebitCard;

import java.math.BigDecimal;

public class DebitCardTests {

    private DebitCard debitCard;

    @BeforeEach
    public void before() {
        debitCard = new DebitCard("500", "Card");
    }

    @Test
    public void test1() {
        debitCard.increaseBalance("100");
        Assertions.assertEquals(new BigDecimal("600"), debitCard.getBalance());
    }

    @Test
    public void test2() {
        debitCard.decreaseBalance("100");
        Assertions.assertEquals(new BigDecimal("400"), debitCard.getBalance());
    }

    @Test
    public void test3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new DebitCard(null, "Card");
        });
    }

    @Test
    public void test4() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new DebitCard("500", null);
        });
    }

    @Test
    public void test4_1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new DebitCard("-500", "Card");
        });
    }

    @Test
    public void test5() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            debitCard.increaseBalance(null);
        });
    }

    @Test
    public void test6() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            debitCard.increaseBalance("-100");
        });
    }

    @Test
    public void test7() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            debitCard.increaseBalance("qwe");
        });
    }

    @Test
    public void test8() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            debitCard.decreaseBalance(null);
        });
    }

    @Test
    public void test9() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            debitCard.decreaseBalance("-100");
        });
    }

    @Test
    public void test10() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            debitCard.decreaseBalance("qwe");
        });
    }

    @Test
    public void test11() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            debitCard.decreaseBalance("1000");
        });
    }


}
