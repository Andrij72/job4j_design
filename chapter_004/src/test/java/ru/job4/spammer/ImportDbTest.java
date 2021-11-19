package ru.job4.spammer;

import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ImportDbTest {

    @Test
    public void saveInDb() throws SQLException, IOException, ClassNotFoundException {
        ImportDb db = new ImportDb("./src/test/dump.txt");
        db.save(db.load());
        List<User> usrs = db.findAll();
        assertThat(usrs.get(0).getName(), is("Ivan Ivanov"));
        assertThat(usrs.get(0).getEmail(), is("iivanov@gmail.com"));
    }

    @Test
    public void load() throws SQLException, IOException, ClassNotFoundException {
        List<User> exp = new ImportDb("./src/test/dump.txt").load();
        List<User> expect = exp.stream().filter(user ->
                user.getName().equals("Ivan Ivanov") && user.getEmail().equals("iivanov@gmail.com")).collect(Collectors.toList());
        assertThat(expect.size(), is(1));
    }


}
