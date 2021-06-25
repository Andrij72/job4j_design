package map.mymap;

public interface MapI<K, V> extends Iterable<V> {
    boolean put(K key, V value);

    V get(K key);

    boolean remove(K key);
}

