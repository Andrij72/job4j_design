package ru.job4.jdbc;

import org.junit.Test;
import org.postgresql.util.PSQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TableEditorTest {

    @Test
    public void checkTableEditorClass() throws Exception {
        Property properties = new Property();
        properties.load("app_load.properties");

        try (TableEditor tableEditor = new TableEditor(properties)) {
            tableEditor.dropTable("test");
            tableEditor.createTable("test");
            tableEditor.addColumn("test", "column1", "varchar");
            tableEditor.addColumn("test", "column2", "varchar");
            tableEditor.addColumn("test", "column3", "varchar");
            tableEditor.renameColumn("test", "column3", "column_change");
            tableEditor.dropColumn("test", "column2");
            StringBuilder expected = new StringBuilder();
            expected.append(String.format("%-15s|%-15s%n", "column_name", "type"));
            expected.append(String.format("%-15s|%-15s%n", "column1", "varchar"));
            expected.append(String.format("%-15s|%-15s%n", "column_change", "varchar"));
            assertThat(tableEditor.getTableScheme("test"), is(expected.toString()));            //h
        }
    }

    @Test(expected = PSQLException.class)
    public void checkDropTable() throws Exception {
        Property properties = new Property();
        properties.load("app_load.properties");
        try (TableEditor tableEditor = new TableEditor(properties)) {
            tableEditor.createTable("test");
            tableEditor.dropTable("test");
            tableEditor.getTableScheme("test");
        }
    }
}