package ru.job4j.tdd;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

@Ignore
public class CinemaTest {

    @Ignore
    @Test
    public void add() {
        Cinema cinema = new Cinema3D();
        cinema.setName("Jobs: The Empire of temptation");
        Calendar startDate = Calendar.getInstance();
        startDate.set(2020, Calendar.OCTOBER, 10, 10, 30);
        Calendar finishDate = Calendar.getInstance();
        finishDate.set(2020, Calendar.OCTOBER, 10, 11, 50);
        Session sessionNew = new Session3D(cinema, startDate, finishDate);
        cinema.add(sessionNew);
        List<Session> sessions = cinema.find(session -> true);
        assertTrue(sessions.contains(new Session3D()));
    }

    @Ignore
    @Test
    public void find() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.NOVEMBER, 10, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Test
    public void buy() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }
}
