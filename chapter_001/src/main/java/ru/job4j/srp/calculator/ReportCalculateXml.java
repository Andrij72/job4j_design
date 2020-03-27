package ru.job4j.srp.calculator;

public class ReportCalculateXml {
    public static String generateXML(double a, double b, char c) {
        StringBuilder builder = new StringBuilder();
        EngineCalculator calculator = new EngineCalculator();
        double res = calculator.calculate(a, b, c);
        builder.append("<?xml version= \"1.0\"?>" + "\n"
                + "<?mso-application progid=\"Excel.Sheet\"?>" + "\n"
                + "<Workbook xmlns=\"urn:schemas-microsoft-com:office:spreadsheet\"" + "\n"
                + " xmlns:o=\"urn:schemas-microsoft-com:office:office\"" + "\n"
                + " xmlns:x=\"urn:schemas-microsoft-com:office:excel\"" + "\n"
                + " xmlns:ss=\"urn:schemas-microsoft-com:office:spreadsheet\"" + "\n"
                + " xmlns:html=\"http://www.w3.org/TR/REC-html40\">" + "\n"
                + " <Table ss:ExpandedColumnCount=\"3\" ss:ExpandedRowCount=\"2\" x:FullColumns=\"1\" " + "\n"
                + " x:FullRows=\"1\" ss:DefaultRowHeight=\"15\">\"" + "\n"
        );

        builder.append("<Row>" + "\n")
                .append("<Cell><Data ss:Type=\"String\">Number1</Data></Cell>")
                .append(System.lineSeparator())
                .append(" <Cell><Data ss:Type=\"String\">Operator</Data></Cell>")
                .append(System.lineSeparator())
                .append(" <Cell><Data ss:Type=\"String\">Opera</Data></Cell>")
                .append(System.lineSeparator())
                .append(" <Cell><Data ss:Type=\"String\">Rez</Data></Cell>")
                .append(System.lineSeparator())
                .append("</Row>")
                .append(System.lineSeparator())
                .append("<Row>")
                .append(System.lineSeparator())
                .append(" <Cell><Data ss:Type=\"Number\">")
                .append(calculator.getFirst())
                .append("</Data></Cell>")
                .append(System.lineSeparator())
                .append(" <Cell><Data ss:Type=\"Character\">")
                .append(calculator.getOperation())
                .append("</Data></Cell>")
                .append(System.lineSeparator())
                .append(" <Cell><Data ss:Type=\"Number\">")
                .append(calculator.getSecond())
                .append("</Data></Cell>")
                .append(System.lineSeparator())
                .append("</Row >")
                .append(System.lineSeparator())
                .append("</Table >")
                .append(System.lineSeparator())
                .append("</Workbook>");
        return builder.toString();
    }
}
