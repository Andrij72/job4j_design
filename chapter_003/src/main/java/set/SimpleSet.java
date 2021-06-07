package set;

import list.SimpleArray;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements SetI<T> {
    SimpleArray<T> arLists = new SimpleArray<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleSet<?> simpleSet = (SimpleSet<?>) o;

        return Objects.equals(arLists, simpleSet.arLists);
    }

    @Override
    public int hashCode() {
        return arLists != null ? arLists.hashCode() : 0;
    }

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
