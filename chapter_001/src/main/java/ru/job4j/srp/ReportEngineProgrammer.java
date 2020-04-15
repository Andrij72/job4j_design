package ru.job4j.srp;

import java.util.function.Predicate;

public class ReportEngineProgrammer {
    private MemStore store;

    public ReportEngineProgrammer(Store store) {
        this.store = (MemStore) store;
    }

    public String generatePr(Predicate<Employer> filter) {
        StringBuilder builder = new StringBuilder();
        builder.append("<!DOCTYPE html>" + "\n"
                + "<html lang=\"ru\">" + "\n"
                + " <head>" + "\n"
                + " <meta charset=\"utf - 8\">" + "\n"
                + " <title>Report Employers</title>" + "\n"
                + " <style>" + "\n"
                + "</style> " + "\n"
                + " </head> " + "\n"
                + " <body> " + "\n"
                + " <center>" + "\n"
                + "<r1>Report Employers</r1></br>" + "\n"
                + "</center>" + "\n"
                + "<table border=\"1\"> "
        );
        builder.append("<tr> <th> Name </th> <th> Hired</th> <th>Fired</th> <th>Salary</th> </tr> ");
        builder.append(System.lineSeparator());
        for (Employer employer : store.findBy(filter)) {
            builder.append("<tr><td>")
                    .append(employer.getName())
                    .append("</td> <td>")
                    .append(employer.getHired())
                    .append("</td> <td>")
                    .append(employer.getFired())
                    .append("</td> <td>")
                    .append(employer.getSalary())
                    .append("</td></tr> ")
                    .append(System.lineSeparator())
                    .append("</table>").append(System.lineSeparator()).append("</body>").append(System.lineSeparator()).append("</html>");
        }
        return builder.toString();
    }
}
