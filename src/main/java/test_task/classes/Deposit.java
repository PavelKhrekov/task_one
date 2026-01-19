package test_task.classes;


import test_task.classes.base.AbstractCurrencyBankProduct;
import test_task.classes.validator.OperationArgumentValidator;
import test_task.enums.Currency;
import test_task.interfaces.Increasable;

public class Deposit extends AbstractCurrencyBankProduct implements Increasable {

    protected boolean isActive;

    public Deposit(Currency currency, String balance, String name) {
        super(currency, balance, name);
        this.isActive = true;
    }

    @Override
    public void increaseBalance(String delta) {
        if (!isActive) {
            throw new IllegalArgumentException("Deposit is closed");
        }
        this.balance = this.balance.add(OperationArgumentValidator.checkOperationArgument(delta));
    }

    public void closeDeposit() {
        this.isActive = false;
    }

    public boolean isActive() {
        return isActive;
    }

}
