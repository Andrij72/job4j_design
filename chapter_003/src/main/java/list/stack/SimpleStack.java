package list.stack;

import list.ForwardLinked;

public class SimpleStack<T> {
    ForwardLinked linked = new ForwardLinked();

    /**
     * @return T object  and delete from list
     */
    public T pop() {
        int n = 0;
        ForwardLinked tmp = new ForwardLinked();
        T value = null;
        if (linked.size() == 1) {
            value = (T) linked.deleteFirst();

        }
        while (n < linked.size()) {
                value = (T) linked.deleteFirst();
                if (n != linked.size() - 2) {
                    tmp.add(value);
                }
                n++;
            }
            linked = tmp;
        return value;
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
