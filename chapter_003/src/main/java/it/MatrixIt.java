package it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class  MatrixIt is Iterator for two-dimensional array int[][]
 * <p>
 *
 * @since 2021.04.01
 */
public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int col;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (row < data.length && col == data[row].length) {
            row++;
            col = 0;
        }
        return row < data.length && col < data[row].length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][col++];
    }
}
