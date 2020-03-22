package ru.job4j.srp;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ReportHRTest {

    @Test
    public void generateHR() {
        MemStore store = new MemStore();
        Employer worker1 = new Employer("Andrey", new Date().getTime(), new Date().getTime(), 600);
        Employer worker2 = new Employer("Ivan", new Date().getTime(), new Date().getTime(), 500);
        Employer worker3 = new Employer("Petr", new Date().getTime(), new Date().getTime(), 700);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        ReportHR engine = new ReportHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary")
                .append(System.lineSeparator())
                .append(worker3.getName()).append(";")
                .append(worker3.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator());
        System.out.println(expect);
        assertThat(engine.generateHR(em -> true), is(expect.toString()));
    }
}
