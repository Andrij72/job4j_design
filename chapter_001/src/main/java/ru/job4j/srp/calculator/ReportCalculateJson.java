package ru.job4j.srp.calculator;

public class ReportCalculateJson {
    public static String generateJson(double a, double b, char c) {
        StringBuilder bildRp = new StringBuilder();
        EngineCalculator calculator = new EngineCalculator();
        double res = calculator.calculate(a, b, c);
        bildRp.append("{")
                .append(System.lineSeparator())
                .append("\"number1\": \"")
                .append(calculator.getFirst())
                .append("\",")
                .append(System.lineSeparator())
                .append("\"operator\": \"")
                .append(calculator.getOperation())
                .append("\",")
                .append(System.lineSeparator())
                .append("\"number2\": \"")
                .append(calculator.getSecond())
                .append("\"")
                .append(System.lineSeparator())
                .append("}");
        return bildRp.toString();
    }
}
