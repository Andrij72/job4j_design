package list.stack;

import list.ForwardLinked;

public class SimpleStack<T> {
    ForwardLinked linked = new ForwardLinked();

    /**
     * @return T object  and delete from list
     */
    public T pop() {
        return (T) linked.deleteLast();
    }

    /**
     * @param value add value
     */
    public void push(T value) {
        linked.add(value);
    }

    public int size() {
        return linked.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
