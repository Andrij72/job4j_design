package ru.job4j.tdd;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;


@Getter
@Setter
public class Cinema3D implements Cinema {
private String name;
    public Cinema3D(String name) {
        this.name = name;
    }

    @Override
    public List<Session> find(Predicate<Session> filter) {
        return null;
    }

    @Override
    public Ticket buy(Account account, int row, int column, Calendar date) {
        return null;
    }

    @Override
    public void add(Session session) {

    }
}
