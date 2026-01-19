package test_task.classes.base;

import test_task.classes.validator.OperationArgumentValidator;
import test_task.enums.Currency;
import test_task.interfaces.Decreasable;
import test_task.interfaces.Increasable;

import java.math.BigDecimal;

public abstract class AbstractCard extends AbstractCurrencyBankProduct implements Increasable, Decreasable {

    public AbstractCard(Currency currency, String balance, String name) {
        super(currency, balance, name);
    }

    @Override
    public void increaseBalance(String delta) {
        BigDecimal deltaAsModel = OperationArgumentValidator.checkOperationArgument(delta);
        this.balance = this.balance.add(deltaAsModel);
    }

    @Override
    public void decreaseBalance(String delta) {
        BigDecimal deltaAsModel = OperationArgumentValidator.checkOperationArgument(delta);
        BigDecimal newBalance = this.balance.subtract(deltaAsModel);
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("The balance \"%s\" can't be less zero".formatted(newBalance));
        }
        this.balance = newBalance;
    }

}
