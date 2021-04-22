package it.eventit;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumIterator implements Iterator<Integer> {
    private final int[] massiveNumbers;
    private int elem = 0;

    public EvenNumIterator(int[] numbers) {
        this.massiveNumbers = numbers;
    }
    @Override
    public Integer next() {
        if (!hasNext()) {
           throw new NoSuchElementException();
        }
        return massiveNumbers[elem++];
    }
    @Override
    public boolean hasNext() {
        boolean res = false;
        while (elem < massiveNumbers.length) {
            if (massiveNumbers[elem] % 2 == 0) {
                res = true;
                break;
            }
            elem++;
        }
        return res;
    }
}
