package ru.job4j.srp.calculator;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * Class   for calculating  arithmetic operations + - *
 *
 * @author Andrey Kulynych
 * @version 1.0
 * @since 12.10.2019
 */
public class EngineCalculatorNew {
    interface Operator {
        double calculate(double a, double b);
    }

    public double operate(double a, double b, Operator operator) {
        return operator.calculate(a, b);
    }


    public static void add() {
        Operator result = (first, second) -> first + second;
        System.out.println(" add  " + result);
    }

    public static void div() {
       Operator result = (first, second) -> first / second;
        System.out.println(" /  = " + result);

    }

    /**
     * Method multiply.
     *
     * @param first
     * @param second
     */
    public static void multiply(double first, double second) {
        double result = first / second;
        System.out.println(first + " * " + second + " = " + result);
    }

    public static void subtract(double first, double second) {
        double result = first / second;
        System.out.println(first + " - " + second + " = " + result);
    }



}
