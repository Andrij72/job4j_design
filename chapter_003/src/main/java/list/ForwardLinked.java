package list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node head;
    private int size;

    public int size() {
        return this.size;
    }

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        size++;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T value = (T) head.value;
        head = head.next;
        size--;
        return value;
    }

    public T deleteLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        if (size == 1) {
            T value = (T) head.value;
            head = null;
            size--;
            return value;
        }
        Node<T> current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        size--;
        return current.value;
    }
    /*public boolean revert() {
        Node<T> previous = head;
        Node<T> current = head.next;
        if (size() < 2) {
            return false;
        }
        while (current != null) {
            Node<T> tmp = previous;
            current.next = previous;
            previous = current;
            current = tmp;
        }
       head = previous;
        return true;
    }*/


    public boolean revert() {
        if (size < 2) {
            return false;
        }
        if (head != null) {
            Node<T> prev = null;
            Node<T> current = head;
            Node<T> next = head.next;

            while (next != null) {
                current.next = prev;
                prev = current;
                current = next;
                next = current.next;
            }
            head = current;
            head.next = prev;
            return true;
        }
        return false;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}