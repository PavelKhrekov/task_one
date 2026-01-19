package test_task.classes;


import test_task.classes.base.AbstractCard;
import test_task.enums.Currency;

public class CurrencyDebitCard extends AbstractCard {

    public CurrencyDebitCard(Currency currency, String balance, String name) {
        super(currency, balance, name);
    }
}
