package test_task.classes;

import test_task.classes.base.AbstractCard;
import test_task.classes.validator.OperationArgumentValidator;
import test_task.enums.Currency;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CreditCard extends AbstractCard {

    protected final BigDecimal interestRate;
    protected final BigDecimal startBalance;


    public CreditCard(String balance, String name, String interestRate, String startBalance) {
        super(Currency.RUB, balance, name);
        this.interestRate = OperationArgumentValidator.checkOperationArgument(interestRate);

        if (startBalance == null) {
            throw new IllegalArgumentException("The startBalance can't be null");
        }
        this.startBalance = OperationArgumentValidator.checkOperationArgument(startBalance);
    }

    public BigDecimal getDebt(int overdueDayCount) {
        if (overdueDayCount <= 0) {
            throw new IllegalArgumentException("The overdueDayCount can't be null");
        }
        BigDecimal dailyRate = interestRate
                .divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP)
                .divide(BigDecimal.valueOf(365), 10, RoundingMode.HALF_UP);

        return (startBalance.subtract(balance))
                .multiply(dailyRate.multiply(BigDecimal.valueOf(overdueDayCount)));
    }
}
