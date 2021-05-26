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

    public void addFirst(T data) {
        Node<T> newNode = new Node(data, null);
        if (head == null) {
            head = newNode;
        }
        newNode.next = head;
        head = newNode;
    }

    public void show() {
        if (head == null) {
            System.out.printf("\nLinkedList is  underflow");
            System.exit(1);
        }
        Node<T> crntNode;
        crntNode = head;
        while (crntNode != null) {
            System.out.printf("%d->", crntNode.value);
           crntNode = crntNode.next;
        }

    }

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

    public static void main(String[] args) {
      ForwardLinked obj = new ForwardLinked();
        // insert Stack value
        obj.add(11);
        obj.add(22);
        obj.add(33);
        obj.add(44);

        // print Stack elements
        obj.show();
        obj.addFirst(55);
        obj.addFirst(66);
        obj.deleteFirst();
        System.out.println("\nAfter addFirst and deleteFirst");
        obj.show();
    }

}
