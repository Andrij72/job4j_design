package ru.job4j.srp;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ReportEngineProgrammerTest {

    @Test
    public void whenProgrammerGenerated() {
        MemStore store = new MemStore();
        Employer worker = new Employer("Ivan", new Date().getTime(), new Date().getTime(), 100);
        store.add(worker);
        ReportEngineProgrammer engine = new ReportEngineProgrammer(store);
        StringBuilder res = new StringBuilder();
        res.append("<!DOCTYPE html>" + "\n"
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
        )
                .append("<tr> <th> Name </th> <th> Hired</th> <th>Fired</th> <th>Salary</th> </tr> ")
                .append(System.lineSeparator())
                .append("<tr><td>")
                .append(worker.getName())
                .append("</td> <td>")
                .append(worker.getHired())
                .append("</td> <td>")
                .append(worker.getFired())
                .append("</td> <td>")
                .append(worker.getSalary())
                .append("</td></tr> ")
                .append(System.lineSeparator())
                .append("</table>")
                .append(System.lineSeparator())
                .append("</body>")
                .append(System.lineSeparator())
                .append("</html>");
        System.out.println(res.toString());
        assertThat(engine.generatePr(em -> true), is(res.toString()));
    }
}
