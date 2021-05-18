package list;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private int position = 0;
    private int countMode = 0;
    private Object[] container = new Object[4];

    public T get(int index) {
        Objects.checkIndex(index, position);
        return (T) container[index];
    }

    public void add(T model) {
        if (position == container.length) {
            container = Arrays.copyOf(container, (int) (1.5 * container.length));
        }
        container[position++] = model;
        countMode++;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index;
            private int expectedModCount = countMode;

            @Override
            public boolean hasNext() {
                if (expectedModCount != countMode) {
                    throw new ConcurrentModificationException();
                }
                return index < position;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                position++;
                countMode++;
                return (T) container[index++];
            }
        };
    }
}
