package test_task.classes.base;


import test_task.classes.validator.OperationArgumentValidator;
import test_task.enums.Currency;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class AbstractCurrencyBankProduct {

    protected final Currency currency;
    protected final String name;
    protected BigDecimal balance;

    public AbstractCurrencyBankProduct(Currency currency, String balance, String name) {
        this.currency = Objects.requireNonNull(currency, "The currency can't be null");
        this.balance = OperationArgumentValidator.checkOperationArgument(balance);
        this.name = Objects.requireNonNull(name, "The name can't be null");
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

}
