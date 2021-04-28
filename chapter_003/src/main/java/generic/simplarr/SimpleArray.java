package generic.simplarr;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private final Object[] array;
    private final int length;
    private int position = 0;
    private Iterator<T> cursor = Collections.emptyIterator();

    public SimpleArray(Object[] array, int length) {
        this.array = array;
        this.length = length;
    }

    public boolean add(T model) {
        boolean res = false;
        while (iterator().hasNext()) {

            if (array[position] == null) {
                array[position] = model;
                res = true;
            }
            iterator().next();
        }
        return res;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, array.length);
        array[index] = model;
    }


    public void remove(int index) {
        Objects.checkIndex(index, array.length);
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        array[length - 1] = null;
    }

    public T get(int index) {
        Objects.checkIndex(index, array.length);
        T t = (T) array[index];
        return t;
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
