package map.mymap;


import java.util.*;

public class SimpleMap<K, V> implements MapI<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 16;
    private Node<K, V>[] hashTab;
    private float threshold;
    private int modCount;
    private int size;


    public SimpleMap() {
        modCount = 0;
        size = 0;
        capacity = DEFAULT_CAPACITY;
        threshold = LOAD_FACTOR * capacity;
        hashTab = new Node[capacity];
    }


    @Override
    public boolean put(K key, V value) {
        modCount++;
        if (size > threshold) {
            capacity *= 2;
            resize();
        }
        Node<K, V> newNode = new Node<>(key, value);
        int index = indexFor(hash(key), capacity);
        if (hashTab[index] == null) {
            return insert(index, newNode);
        }
        for (Node<K, V> nd : hashTab[index].nodesList) {
            if (nd.key.hashCode() == key.hashCode()) {
                if (Objects.equals(nd.key, key)) {
                nd.value = value;
                return false;
                }
            }
        }
        hashTab[index].nodesList.add(newNode);
        return true;
    }

    private void resize() {
        Node<K, V>[] newHashTab = hashTab;
        hashTab = new Node[capacity * 2];
        for (Node<K, V> nod : newHashTab) {
            if (nod != null) {
                for (Node<K, V> innerNd : nod.nodesList) {
                    put(innerNd.key, innerNd.value);
                }
            }
        }
    }

    private boolean insert(int index, Node<K, V> newNode) {
        hashTab[index] = new Node<>(null, null);
        hashTab[index].nodesList.add(newNode);
        size++;
        return true;
    }

    @Override
    public V get(K key) {
        int index = indexFor(hash(key), capacity);
        if (hashTab[index] != null) {
            for (Node<K, V> nd : hashTab[index].nodesList) {
                if (Objects.equals(nd.key, key)) {
                    return nd.value;
                }
            }
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        int indx = indexFor(hash(key), capacity);
        if (hashTab[indx] != null) {
            for (Node<K, V> nd : hashTab[indx].nodesList) {
                if (nd.key.hashCode() == key.hashCode()) {
                    if (Objects.equals(nd.key, key)) {
                    hashTab[indx].nodesList.remove(nd);
                    size--;
                    modCount++;
                    return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            private int valueCounter = 0;
            private int bucketCounter = 0;
            private Iterator<Node<K, V>> innerIterator = null;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }

                if (valueCounter == size) {
                    return false;
                }

                if (innerIterator == null || !innerIterator.hasNext()) {
                    bucketCounter++;

                    while (hashTab[bucketCounter] == null && bucketCounter < capacity - 1) {
                        bucketCounter++;
                    }

                    if (bucketCounter < capacity) {
                        innerIterator = hashTab[bucketCounter].nodesList.iterator();
                    } else {
                        return false;
                    }
                }
                return innerIterator.hasNext();
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                valueCounter++;
                return innerIterator.next().value;
            }
        };
    }

    public int hash(K key) {
        int var;
        var = Math.abs(key.hashCode());
        return key == null ? 0 : var & (capacity - 1) ^ (var >>> 16);
    }

    int indexFor(int hash, int capacity) {
        return hash & (capacity - 1);
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private List<Node<K, V>> nodesList = new LinkedList<>();

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
