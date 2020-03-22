package ru.job4j.srp;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ReportBookkeepingTest {

    @Test
    public void generateBookkeeping() {
        MemStore store = new MemStore();
        Employer worker = new Employer("John", new Date().getTime(), new Date().getTime(), 100);
        store.add(worker);
        ReportBookkeeping engine = new ReportBookkeeping(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(120.0).append(";")
                .append(System.lineSeparator());
        String result = engine.generateBookkeeping(em -> true, 1.2);
        System.out.println(result);
        assertThat(result, is(expect.toString()));
    }
}
