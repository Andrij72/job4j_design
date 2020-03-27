package ru.job4j.srp.calculator;

import java.util.function.DoubleBinaryOperator;

public enum Operation {
    ADD('+', (d1, d2) -> d1 + d2),
    SUB('-', (d1, d2) -> d1 - d2),
    MUL('*', (d1, d2) -> d1 * d2),
    DIV('/', (d1, d2) -> d1 / d2);

    private final char element;
    private final DoubleBinaryOperator operator;

    Operation(char element, DoubleBinaryOperator operator) {
        this.element = element;
        this.operator = operator;
    }

    public double getResult(double d1, double d2) {
        return operator.applyAsDouble(d1, d2);
    }

    public char getSymbol() {
        return element;
    }
}
