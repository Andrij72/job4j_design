package ru.job4j.lsp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

@Getter
@Setter
@AllArgsConstructor
public class Food {
    private String name;
    private int expiryDate;
    private LocalDate createDate;
    private double price;
    private int discount;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("[");
        sb.append(name).append('/');
        sb.append(expiryDate).append('/');
        sb.append(createDate).append('/');
        sb.append(price).append('/');
        sb.append(discount);
        sb.append(']');
        return sb.toString();
    }
}
