package generic.simplarr;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private final Object[] array;
    private int countElmnts = 0;
    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    public void add(T model) {
        if (countElmnts < array.length) {
            array[countElmnts++] = model;
        }
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, countElmnts);
        array[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, countElmnts);
        System.arraycopy(array, index + 1, array, index, countElmnts - index - 1);
        array[--countElmnts] = null;
    }

    public T get(int index) {
        Objects.checkIndex(index, countElmnts);
        return (T) array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return position < countElmnts;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[countElmnts++];
            }
        };
    }
}
