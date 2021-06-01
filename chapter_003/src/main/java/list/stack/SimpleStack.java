package list.stack;

import list.ForwardLinked;

import java.util.NoSuchElementException;

public class SimpleStack<T> {
    ForwardLinked linked = new ForwardLinked();
    /**
     * @return T object  and delete from list
     */
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (T) linked.deleteFirst();
    }

    /**
     * @param value add value
     */
    public void push(T value) {
        linked.addFirst(value);
    }

    public int size() {
        return linked.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void showStk() {
        linked.show();
    }

}
