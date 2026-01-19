package test_task.classes;


import test_task.classes.base.AbstractCard;
import test_task.enums.Currency;

public class DebitCard extends AbstractCard {

    public DebitCard(String balance, String name) {
        super(Currency.RUB, balance, name);
    }

}
