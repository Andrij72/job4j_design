package it;

import java.util.Iterator;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] m;
    private int i;
    private int j;

    public MatrixIt(int[][] m) {
        this.m = m;
    }

    @Override
    public boolean hasNext() {
        return i < m.length && j < m[i].length;
    }

    @Override
    public Integer next() {
       int res = Integer.parseInt(null);
        if (!hasNext()) {
            new ElementMatrixEx("Matrix have't element");
        }
        if (i < m.length) {
            j = 0;
            res = m[i++][j];
        } else if (j < m[i].length) {
            res = m[i][j];
            j++;
        }
        return res;
    }
}