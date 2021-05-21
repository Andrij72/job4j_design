package list.smpllinklst;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {
    private Node head;
    private int modeCounter = 0;
    private int size = 0;

    @Override
    public void add(E value) {
        Node<E> node = new Node<E>(value);
        if (head == null) {
            head = node;
            size++;
            modeCounter++;
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = new Node(value, null);
        size++;
        modeCounter++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> nod = head;
        for (int i = 0; i < index; i++) {
            nod = nod.next;
        }

        return nod.value;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> node = head;
            private int index = 0;
            private int expectedModCount = modeCounter;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modeCounter) {
                    throw new ConcurrentModificationException();
                }
                return index < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                node = node.next;
                index++;
                return node.value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node next;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
