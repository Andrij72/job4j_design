package generic.simplarr;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private final Object[] array;
    private int length;
    private int position = 0;
    private Iterator<T> cursor = Collections.emptyIterator();

    public SimpleArray(Object[] array, int length) {
        this.array = array;
        this.length = length;
    }

    public void add(T model) {
        if (position < array.length) {
            array[position++] = model;
        }
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, array.length);
        array[index] = model;
    }


    public void remove(int index) {
        Objects.checkIndex(index, array.length);
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        array[--length] = null;
    }

    public T get(int index) {
        Objects.checkIndex(index, array.length);
        return (T) array[index];
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return position < array.length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[position++];
            }
        };
    }
}
