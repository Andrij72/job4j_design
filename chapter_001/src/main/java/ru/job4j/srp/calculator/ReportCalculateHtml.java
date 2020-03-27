package ru.job4j.srp.calculator;

public class ReportCalculateHtml {

    public static String generate(double a, double b, char c) {
        StringBuilder text = new StringBuilder();
        EngineCalculator calculator = new EngineCalculator();
        double res = calculator.calculate(a, b, c);
        text.append("<!DOCTYPE html>" + "\n"
                + "<html lang=\"ru\">" + "\n"
                + " <head>" + "\n"
                + " <meta charset=\"utf - 8\">" + "\n"
                + " <title>Report Calculator</title>" + "\n"
                + " <style>" + "\n"
                + "</style> " + "\n"
                + " </head> " + "\n"
                + " <body> " + "\n"
                + "<h1>Report RESULT calculation</h1></br>" + "\n"
                + "<table border=\"1\"> "
        );
        text.append("<tr> <th> Number1 </th> <th> Operation</th> <th>Number2</th> <th>Result</th> </tr> ")
                .append(System.lineSeparator())
                .append("<tr><td>")
                .append(calculator.getFirst())
                .append("</td> <td>")
                .append(calculator.getOperation())
                .append("</td> <td>")
                .append(calculator.getSecond())
                .append("</td> <td>")
                .append(res)
                .append("</td></tr> ")
                .append(System.lineSeparator())
                .append("</table>")
                .append(System.lineSeparator())
                .append("</body>")
                .append(System.lineSeparator()).append("</html>");
        return text.toString();
    }
}

