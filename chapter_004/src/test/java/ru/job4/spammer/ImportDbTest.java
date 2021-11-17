package ru.job4.spammer;

import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
}
