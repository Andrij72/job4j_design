package set;

import list.SimpleArray;

import java.util.Iterator;

public class SimpleSet<T> implements SetI<T> {
    SimpleArray<T> arLists = new SimpleArray<>();

    @Override
    public boolean add(T value) {
        if (!contains(value)) {
            arLists.add(value);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(T value) {
        Iterator<T> it = arLists.iterator();
        while (it.hasNext()) {
            if (it.next() == value) {
                return true;
            }
        }
        return false;
    }
}
