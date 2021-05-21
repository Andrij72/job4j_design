package generic.store;

public class RoleStore<T extends Base> implements Store<Role> {
    final Store<Role> st = new MemStore<>();

    @Override
    public void add(Role model) {
        st.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        return st.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return st.delete(id);
    }

    @Override
    public Role findById(String id) {
       return st.findById(id);
    }
}
