package test_task.classes.validator;

import java.math.BigDecimal;

public final class OperationArgumentValidator {


    /**
     *
     * ожидается, что значение для операций пополнения и снятия не должны
     * быть: null, отрицательными, невалидными(например "qwe")
     *
     * @param argument - значение для, операций пополнения или снятия с баланса
     * @return - провалидированное значение типа BigDecimal
     */
    public static BigDecimal checkOperationArgument(String argument) {
        BigDecimal valueAsBigDecimal;
        if (argument == null) {
            throw new IllegalArgumentException("The argument can't be null");
        }
        try {
            valueAsBigDecimal = new BigDecimal(argument);
            if (valueAsBigDecimal.compareTo(BigDecimal.ZERO) < 0) {
                throw new IllegalArgumentException("The argument \"%s\" can't be less zero".formatted(argument));
            }
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("\"%s\" wrong format to balance".formatted(argument), exception);
        }
        return valueAsBigDecimal;
    }
}
