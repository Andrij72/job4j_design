package generic.store;

import java.util.ArrayList;
import java.util.List;

public class MemStore<T extends Base> implements Store<T> {
    private final List<T> arch = new ArrayList<>();

    @Override
    public void add(T model) {
        arch.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int indx = findIndexById(id);
        if (indx != -1) {
            arch.set(indx, model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        int indx = findIndexById(id);
        if (indx != -1) {
            arch.remove(indx);
            return true;
        }
        return false;
    }

    public int findIndexById(String id) {
        for (int k = 0; k < arch.size(); k++) {
            if (arch.get(k).equals(id)) {
                return k;
            }
        }
        return -1;
    }

    @Override
    public T findById(String id) {
        int indx = findIndexById(id);
        if (indx != -1) {
            return arch.get(indx);
        }
        return null;
    }
}
