package ru.job4j.srp.calculator;

import lombok.Getter;
import lombok.Setter;

import java.util.stream.Stream;

@Setter
@Getter
public class EngineCalculator {
    private double first;
    private double second;
    private char operation;

    public double calculate(double a, double b, char c) {
        setFirst(a);
        setSecond(b);
        setOperation(c);
        Operation operation = Stream.of(Operation.values())
                .filter(el -> el.getSymbol() == c)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("This operator doesn't exist"));
        return operation.getResult(a, b);
    }
}
