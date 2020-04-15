package ru.job4j.srp;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportHR {
    private MemStore store;

    public ReportHR(Store store) {
        this.store = (MemStore) store;
    }

    public String generateHR(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary")
                .append(System.lineSeparator());
        List<Employer> listF = store.findBy(filter);
        listF.sort(Comparator.comparingDouble(Employer::getSalary).reversed());
        for (Employer employer : listF) {
            text.append(employer.getName()).append(";")
                    .append(employer.getSalary()).append(";")
                    .append(System.lineSeparator());

        }
        return text.toString();
    }
}
