package ru.job4j.srp;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ReportEngineTest {
    
    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();

        Employer worker = new Employer("Ivan", new Date().getTime(), new Date().getTime(), 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        System.out.println(expect);
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}
