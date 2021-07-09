package tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;


public class SimpleTree<E> implements Tree<E> {
    private Node<E> root;

    public SimpleTree(E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> prEl = findBy(parent);
        if (!prEl.isEmpty()) {
            if (findBy(child).isEmpty()) {
                prEl.get().getChildren().add(new Node<>(child));
                return true;
            }
        }
        return false;
    }


    /* In next refactoring this method with Predicate<Node<E>> condition.
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
     */


    @Override
    public Optional<Node<E>> findBy(E value) {
        return findByPredicate(eNode -> Objects.equals(eNode.getValue(), value));
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        Node<E> el = data.poll();
        data.offer(this.root);
        while (!data.isEmpty()) {
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.getChildren());
        }
        return rsl;
    }

    public boolean isBinary() {
        return findByPredicate(eNode -> eNode.getChildren().size() > 2).isEmpty();
    }

}
