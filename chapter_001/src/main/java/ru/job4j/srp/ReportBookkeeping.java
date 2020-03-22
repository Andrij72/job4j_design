package ru.job4j.srp;

import java.util.function.Predicate;

public class ReportBookkeeping {
    private Store store;

    public ReportBookkeeping(Store store) {
        this.store = store;
    }

    public String generateBookkeeping(Predicate<Employer> filter, double kf) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator());
        for (Employer employer : store.findBy(filter)) {
            text.append(employer.getName()).append(";")
                    .append(employer.getHired()).append(";")
                    .append(employer.getFired()).append(";")
                    .append(employer.getSalary() * kf).append(";")
                    .append(System.lineSeparator());

        }
        return text.toString();
    }
}
