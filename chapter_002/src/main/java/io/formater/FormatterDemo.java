package io.formater;

import java.util.Formatter;

/**
 * Using Formater
 */
public class FormatterDemo {
    public static void main(String[] args) {
        StringBuilder sbuf = new StringBuilder();
        Formatter frm = new Formatter(sbuf);
        frm.format("PI=%f%n", Math.PI);
        System.out.println(sbuf);
        sbuf.delete(0, sbuf.length() - 1);
        frm.format("|%020d|%n", 87);
        String str2 = String.format("|%-20d|%n", 87);
        System.out.println(sbuf + str2);
    }

}
